package client.impl;

/**
 * @author lxg
 * @create 2018-06-07 11:10
 * @desc 交易
 */
public interface TransactionApi {
    String transfer(String privacyKey, String from, String to, double amount, String contract);
}
