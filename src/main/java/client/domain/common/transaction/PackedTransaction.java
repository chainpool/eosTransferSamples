package client.domain.common.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.util.List;

@Data
public class PackedTransaction {

    private String region;

    private int maxNetUsageWords;

    private String expiration;

    private Long refBlockPrefix;

    private Long refBlockNum;

//    private String maxKcpuUsage;

    private List<String> contextFreeData;

    private List<TransactionAction> contextFreeActions;

    private List<TransactionAction> actions;

    private int delaySec;

    private int max_cpu_usage_ms;

    private String fee;

    public void setMaxNetUsageWords(int maxNetUsageWords) {
        this.maxNetUsageWords = maxNetUsageWords;
    }

    @JsonProperty("max_cpu_usage_ms")
    public int getMax_cpu_usage_ms() {
        return max_cpu_usage_ms;
    }

    public void setMax_cpu_usage_ms(int max_cpu_usage_ms) {
        this.max_cpu_usage_ms = max_cpu_usage_ms;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getMaxNetUsageWords() {
        return maxNetUsageWords;
    }

    @JsonProperty("max_net_usage_words")
    public void setMax_net_usage_words(int maxNetUsageWords) {
        this.maxNetUsageWords = maxNetUsageWords;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public Long getRefBlockPrefix() {
        return refBlockPrefix;
    }

    @JsonProperty("ref_block_prefix")
    public void setRefBlockPrefix(Long refBlockPrefix) {
        this.refBlockPrefix = refBlockPrefix;
    }

//    public String getMaxKcpuUsage() {
//        return maxKcpuUsage;
//    }

//    @JsonProperty("max_kcpu_usage")
//    public void setMaxKcpuUsage(String maxKcpuUsage) {
//        this.maxKcpuUsage = maxKcpuUsage;
//    }

    public Long getRefBlockNum() {
        return refBlockNum;
    }

    @JsonProperty("ref_block_num")
    public void setRefBlockNum(Long refBlockNum) {
        this.refBlockNum = refBlockNum;
    }

    public List<String> getContextFreeData() {
        return contextFreeData;
    }

    @JsonProperty("context_free_data")
    public void setContextFreeData(List<String> contextFreeData) {
        this.contextFreeData = contextFreeData;
    }


    public List<TransactionAction> getContextFreeActions() {
        return contextFreeActions;
    }

    @JsonProperty("context_free_actions")
    public void setContextFreeActions(List<TransactionAction> contextFreeActions) {
        this.contextFreeActions = contextFreeActions;
    }

    public List<TransactionAction> getActions() {
        return actions;
    }

    public void setActions(List<TransactionAction> actions) {
        this.actions = actions;
    }

    public int getDelaySec() {
        return delaySec;
    }

    @JsonProperty("delay_sec")
    public void setDelaySec(int delaySec) {
        this.delaySec = delaySec;
    }


    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
