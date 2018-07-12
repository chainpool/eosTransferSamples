package client.domain.common.transaction;


import java.util.List;

public class SignedPackedTransaction extends PackedTransaction {

    private List<String> signatures;

    private List<String> transaction_extensions;
    public SignedPackedTransaction(){

    }

    public List<String> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<String> signatures) {
        this.signatures = signatures;
    }

    public List<String> getTransaction_extensions() {
        return transaction_extensions;
    }

    public void setTransaction_extensions(List<String> transaction_extensions) {
        this.transaction_extensions = transaction_extensions;
    }
}
