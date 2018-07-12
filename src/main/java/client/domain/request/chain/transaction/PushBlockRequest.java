package client.domain.request.chain.transaction;

import client.domain.common.transaction.BlockTransaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxg
 * @create 2018-06-07 15:32
 * @desc
 */
public class PushBlockRequest {
    private String timestamp;
    private String producer;
    private int confirmed;
    private String previous;
    private String transaction_mroot;
    private String action_mroot;
    private int schedule_version;
    private String new_producers;
    private List<String> header_extensions = new ArrayList<>();
    private String producer_signature;
    private List<BlockTransaction> transactions = new ArrayList<>();
    private List<String> block_extensions = new ArrayList<>();
    private String id;
    private long block_num;
    private long ref_block_prefix;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getTransaction_mroot() {
        return transaction_mroot;
    }

    public void setTransaction_mroot(String transaction_mroot) {
        this.transaction_mroot = transaction_mroot;
    }

    public String getAction_mroot() {
        return action_mroot;
    }

    public void setAction_mroot(String action_mroot) {
        this.action_mroot = action_mroot;
    }

    public int getSchedule_version() {
        return schedule_version;
    }

    public void setSchedule_version(int schedule_version) {
        this.schedule_version = schedule_version;
    }

    public String getNew_producers() {
        return new_producers;
    }

    public void setNew_producers(String new_producers) {
        this.new_producers = new_producers;
    }

    public List<String> getHeader_extensions() {
        return header_extensions;
    }

    public void setHeader_extensions(List<String> header_extensions) {
        this.header_extensions = header_extensions;
    }

    public String getProducer_signature() {
        return producer_signature;
    }

    public void setProducer_signature(String producer_signature) {
        this.producer_signature = producer_signature;
    }

    public List<BlockTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<BlockTransaction> transactions) {
        this.transactions = transactions;
    }

    public List<String> getBlock_extensions() {
        return block_extensions;
    }

    public void setBlock_extensions(List<String> block_extensions) {
        this.block_extensions = block_extensions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getBlock_num() {
        return block_num;
    }

    public void setBlock_num(long block_num) {
        this.block_num = block_num;
    }

    public long getRef_block_prefix() {
        return ref_block_prefix;
    }

    public void setRef_block_prefix(long ref_block_prefix) {
        this.ref_block_prefix = ref_block_prefix;
    }
}
