package witchub.com.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;

public class SellerFeedback {

    @NotNull
    private int sellerFeedbackId;

    private Date date;
    private Time time;

    @NotEmpty
    private String subject;

    @NotEmpty
    private String message;

    private String response;

    // foreign key(s)
    private int sellerId;
    private int staffId;

    public SellerFeedback(int sellerFeedbackId, Date date, Time time, String subject, String message, String response, int sellerId, int staffId) {
        this.sellerFeedbackId = sellerFeedbackId;
        this.date = date;
        this.time = time;
        this.subject = subject;
        this.message = message;
        this.response = response;
        this.sellerId = sellerId;
        this.staffId = staffId;
    }

    public int getSellerFeedbackId() {
        return sellerFeedbackId;
    }

    public void setSellerFeedbackId(int sellerFeedbackId) {
        this.sellerFeedbackId = sellerFeedbackId;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "SellerFeedback{" +
                "sellerFeedbackId=" + sellerFeedbackId +
                ", date=" + date +
                ", time=" + time +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", response='" + response + '\'' +
                ", sellerId=" + sellerId +
                ", staffId=" + staffId +
                '}';
    }
}
