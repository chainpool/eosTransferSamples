package client.domain.common.transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lxg
 * @create 2018-06-07 17:34
 * @desc
 */
public class BlockTransactionAction {
    private String account;
    private String name;
    private List<BlockTransactionAuthorization> authorization;
    private String hex_data;
    private Map<String, Object> data = new HashMap<>();

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BlockTransactionAuthorization> getAuthorization() {
        return authorization;
    }

    public void setAuthorization(List<BlockTransactionAuthorization> authorization) {
        this.authorization = authorization;
    }

    public String getHex_data() {
        return hex_data;
    }

    public void setHex_data(String hex_data) {
        this.hex_data = hex_data;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
