package client.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lxg
 * @create 2018-06-08 16:54
 * @desc
 */
@ConfigurationProperties(prefix = "eos")
@Component
public class EosConfig {
    private String nodeUrl;

    public String getNodeUrl() {
        return nodeUrl;
    }

    public void setNodeUrl(String nodeUrl) {
        this.nodeUrl = nodeUrl;
    }
}
