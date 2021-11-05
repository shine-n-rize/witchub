package witchub.com.models;

import javax.validation.constraints.NotNull;

public class Buyer {

    @NotNull
    private int buyerId;

    private String accountNo;
    private String bankName;
    private String bankBranch;
    private String ifscCode;

    // foreign key(s)
    private int userId;

    public Buyer(int buyerId, String accountNo, String bankName, String bankBranch, String ifscCode, int userId) {
        this.buyerId = buyerId;
        this.accountNo = accountNo;
        this.bankName = bankName;
        this.bankBranch = bankBranch;
        this.ifscCode = ifscCode;
        this.userId = userId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "buyerId=" + buyerId +
                ", accountNo='" + accountNo + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankBranch='" + bankBranch + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", userId=" + userId +
                '}';
    }
}
