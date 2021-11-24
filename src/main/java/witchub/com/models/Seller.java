package witchub.com.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Seller {

    // primary + foreign key
    @NotNull
    private int sellerId;

    private int wallet;
    private float demandRate;

    @NotEmpty
    private String accountNo;

//    public Seller(int sellerId, boolean isValid, int wallet, float demandRate, String accountNo, int userId) {
//        this.sellerId = sellerId;
//        this.wallet = wallet;
//        this.demandRate = demandRate;
//        this.accountNo = accountNo;
//        this.userId = userId;
//    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public float getDemandRate() {
        return demandRate;
    }

    public void setDemandRate(float demandRate) {
        this.demandRate = demandRate;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerId=" + sellerId +
                ", wallet=" + wallet +
                ", demandRate=" + demandRate +
                ", accountNo='" + accountNo + '\'' +
                '}';
    }
}
