package client.impl;

import client.util.EosConfig;
import client.crypto.ec.EosPrivateKey;
import client.crypto.model.api.EosChainInfo;
import client.crypto.model.chain.Action;
import client.crypto.model.chain.SignedTransaction;
import client.crypto.model.types.TypeChainId;
import client.domain.response.chain.AbiJsonToBin;
import client.domain.response.chain.ChainInfo;
import client.util.LLogger;
import client.util.LLoggerFactory;
import client.util.Utils;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author lxg
 * @create 2018-06-07 11:21
 * @desc 交易信息
 */
@Service
public class TransactionApiImpl implements TransactionApi {

    private LLogger lLogger = LLoggerFactory.getLogger(TransactionApiImpl.class);
    @Autowired
    private EosConfig eosConfig;

    @Override
    public String transfer(String privacyKey, String from, String to, double amount, String contract) {
        double feeVal = 0.01;
        String fee = Utils.getEosBalance(feeVal);
        String action = "transfer";
        Map<String, String> params = new HashMap<>(4);
        params.put("from", from);
        params.put("to", to);
        params.put("quantity", Utils.getEosBalance(amount));
        params.put("memo", "");
        return packedTransaction(privacyKey, params, from, action, fee, contract);
    }

    private String packedTransaction(String privacyKey, Map<String, String> params, String activer, String action, String fee, String contract) {
        EosApiRestClient eosApiRestClient = EosApiClientFactory.newInstance(eosConfig.getNodeUrl()).newRestClient();
        Map<String, String> abiParams = new HashMap<>();
        abiParams.put("account_name", contract);
        ChainInfo chainInfo = eosApiRestClient.getChainInfo();
        EosPrivateKey eosPrivateKey = new EosPrivateKey(privacyKey);
        TypeChainId chainId = new TypeChainId(chainInfo.getChainId());
        AbiJsonToBin data = eosApiRestClient.abiJsonToBin(contract, action, params);
        lLogger.info("data: {}", Utils.toJson(data));
        EosChainInfo eosChainInfo = new EosChainInfo();
        eosChainInfo.setHeadBlockTime(chainInfo.getHeadBlockTime());
        eosChainInfo.setHeadBlockId(chainInfo.getHeadBlockId());

        SignedTransaction transaction = createTransaction(contract, action, data.getBinargs(), getActivePermission(activer), eosChainInfo, fee);
        transaction = signTransaction(transaction, eosPrivateKey, chainId);
        client.crypto.model.chain.PackedTransaction packedTransaction = buildTransaction(transaction);
        lLogger.info("trx request: {}", Utils.toJson(packedTransaction));
        JsonNode pushTxnResponse = eosApiRestClient.pushTransaction(packedTransaction);
        lLogger.info("packed: {}", Utils.toJsonByGson(pushTxnResponse));
        if (pushTxnResponse != null) {
            JsonNode transaction_id = pushTxnResponse.findValue("transaction_id");
            JsonNode result = transaction_id.findValue("_value");
            if (result != null) {
                lLogger.info("txId: {}", result.asText());
                return result.asText();
            } else {
                lLogger.info("txId: {}", transaction_id.asText());
                return transaction_id.asText();
            }
        }
        return null;
    }


    public client.crypto.model.chain.PackedTransaction buildTransaction(SignedTransaction stxn) {
        return new client.crypto.model.chain.PackedTransaction(stxn);
    }

    public SignedTransaction signTransaction(final SignedTransaction txn,
                                             EosPrivateKey privateKey, final TypeChainId id) throws IllegalStateException {
        SignedTransaction stxn = new SignedTransaction(txn);
        stxn.sign(privateKey, id);
        return stxn;
    }

    private SignedTransaction createTransaction(String contract, String actionName, String dataAsHex,
                                                String[] permissions, EosChainInfo chainInfo, String fee) {
        Action action = new Action(contract, actionName);
        action.setAuthorization(permissions);
        action.setData(dataAsHex);

        SignedTransaction txn = new SignedTransaction();
        txn.addAction(action);
        txn.putSignatures(new ArrayList<>());
        txn.setFee(fee);
        if (null != chainInfo) {
            txn.setReferenceBlock(chainInfo.getHeadBlockId());
            txn.setExpiration(chainInfo.getTimeAfterHeadBlockTime(Utils.getRandNumber(30000, 300000)));
        }
        lLogger.info("rawTransaction: {}", txn);
        return txn;
    }

    private String[] getActivePermission(String accountName) {
        return new String[]{accountName + "@active"};
    }
}
