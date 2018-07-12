package client.domain.common.transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxg
 * @create 2018-06-07 17:30
 * @desc
 */
public class BlockTransactionInfo {
    private String expiration;
    private long ref_block_num;
    private long ref_block_prefix;
    private long max_net_usage_words;
    private long max_cpu_usage_ms;
    private long delay_sec;
    private List<Double> context_free_actions = new ArrayList<>();
    private List<BlockTransactionAction> actions = new ArrayList<>();
    private List<String> transaction_extensions = new ArrayList<>();
    private String fee;

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public long getRef_block_num() {
        return ref_block_num;
    }

    public void setRef_block_num(long ref_block_num) {
        this.ref_block_num = ref_block_num;
    }

    public long getRef_block_prefix() {
        return ref_block_prefix;
    }

    public void setRef_block_prefix(long ref_block_prefix) {
        this.ref_block_prefix = ref_block_prefix;
    }

    public long getMax_net_usage_words() {
        return max_net_usage_words;
    }

    public void setMax_net_usage_words(long max_net_usage_words) {
        this.max_net_usage_words = max_net_usage_words;
    }

    public long getMax_cpu_usage_ms() {
        return max_cpu_usage_ms;
    }

    public void setMax_cpu_usage_ms(long max_cpu_usage_ms) {
        this.max_cpu_usage_ms = max_cpu_usage_ms;
    }

    public long getDelay_sec() {
        return delay_sec;
    }

    public void setDelay_sec(long delay_sec) {
        this.delay_sec = delay_sec;
    }

    public List<Double> getContext_free_actions() {
        return context_free_actions;
    }

    public void setContext_free_actions(List<Double> context_free_actions) {
        this.context_free_actions = context_free_actions;
    }

    public List<BlockTransactionAction> getActions() {
        return actions;
    }

    public void setActions(List<BlockTransactionAction> actions) {
        this.actions = actions;
    }

    public List<String> getTransaction_extensions() {
        return transaction_extensions;
    }

    public void setTransaction_extensions(List<String> transaction_extensions) {
        this.transaction_extensions = transaction_extensions;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
