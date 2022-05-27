package eWallet.eWalletDDD.domain;

public class EWallet {

    /**
     * Domain model - combined data + biz logics
     * */
    long id;

    long walletId;

    long amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getWalletId() {
        return walletId;
    }

    public void setWalletId(long walletId) {
        this.walletId = walletId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    // 充血模型
    public void credit(long id, long amount) {}

    public void debit(long id, long amount) {}




}
