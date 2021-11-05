package witchub.com.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Time;

public class Payment {

    @NotNull
    private int paymentId;

    private boolean isSuccess;

    @Size(min = 5, max = 20)
    private String accountNo;

    private int to;

    @Min(0)
    private int amount;

    private String method;
    private Date date;

    private Time time;

    public Payment(int paymentId, boolean isSuccess, String accountNo, int to, int amount, String method, Date date, Time time) {
        this.paymentId = paymentId;
        this.isSuccess = isSuccess;
        this.accountNo = accountNo;
        this.to = to;
        this.amount = amount;
        this.method = method;
        this.date = date;
        this.time = time;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", isSuccess=" + isSuccess +
                ", accountNo='" + accountNo + '\'' +
                ", to=" + to +
                ", amount=" + amount +
                ", method='" + method + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
