package client.controller;

import client.impl.TransactionApi;
import client.rpc.ReqTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxg
 * @create 2018-06-08 16:03
 */
@RequestMapping("/tx")
@RestController
public class TransactionController {

    @Autowired
    private TransactionApi transactionApi;

    @RequestMapping("/transfer")
    public void transfer(@RequestBody ReqTransfer reqTransfer) {
        transactionApi.transfer(reqTransfer.getPrivacyKey(), reqTransfer.getFrom(), reqTransfer.getTo(), reqTransfer.getAmount(), reqTransfer.getContract());
    }
}
