package client.domain.common.transaction;

/**
 * @author lxg
 * @create 2018-06-07 17:21
 * @desc
 */
public class BlockTransaction {
    private String status;
    private int cpu_usage_us;
    private int net_usage_words;
    private BlockTrx trx;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCpu_usage_us() {
        return cpu_usage_us;
    }

    public void setCpu_usage_us(int cpu_usage_us) {
        this.cpu_usage_us = cpu_usage_us;
    }

    public int getNet_usage_words() {
        return net_usage_words;
    }

    public void setNet_usage_words(int net_usage_words) {
        this.net_usage_words = net_usage_words;
    }

    public BlockTrx getTrx() {
        return trx;
    }

    public void setTrx(BlockTrx trx) {
        this.trx = trx;
    }
}
