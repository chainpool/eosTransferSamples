package client.domain.common.transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxg
 * @create 2018-06-07 17:26
 * @desc
 */
public class BlockTrx {
    private String id;
    private List<String> signatures;
    private String compression;
    private String packed_context_free_data;
    private List<Double> context_free_data = new ArrayList<>();
    private String packed_trx;
    private BlockTransactionInfo transaction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<String> signatures) {
        this.signatures = signatures;
    }

    public String getCompression() {
        return compression;
    }

    public void setCompression(String compression) {
        this.compression = compression;
    }

    public String getPacked_context_free_data() {
        return packed_context_free_data;
    }

    public void setPacked_context_free_data(String packed_context_free_data) {
        this.packed_context_free_data = packed_context_free_data;
    }

    public List<Double> getContext_free_data() {
        return context_free_data;
    }

    public void setContext_free_data(List<Double> context_free_data) {
        this.context_free_data = context_free_data;
    }

    public String getPacked_trx() {
        return packed_trx;
    }

    public void setPacked_trx(String packed_trx) {
        this.packed_trx = packed_trx;
    }

    public BlockTransactionInfo getTransaction() {
        return transaction;
    }

    public void setTransaction(BlockTransactionInfo transaction) {
        this.transaction = transaction;
    }
}
