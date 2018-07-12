package client.domain.common.transaction;

/**
 * @author lxg
 * @create 2018-06-07 17:56
 * @desc
 */
public class BlockTransactionAuthorization {
    private String actor;
    private String permission;

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
