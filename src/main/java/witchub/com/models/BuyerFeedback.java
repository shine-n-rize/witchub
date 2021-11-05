package witchub.com.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;

public class BuyerFeedback {

    @NotNull
    private int buyerFeedbackId;

    private Date date;
    private Time time;

    @NotEmpty
    private String subject;

    @NotEmpty
    private String message;

    private String response;

    // foreign key(s)
    private int buyerId;
    private int staffId;

    public BuyerFeedback(int feedbackId, Date date, Time time, String subject, String message, String response, int userId, int staffId) {
        this.buyerFeedbackId = feedbackId;
        this.date = date;
        this.time = time;
        this.subject = subject;
        this.message = message;
        this.response = response;
        this.buyerId = userId;
        this.staffId = staffId;
    }

    public int getBuyerFeedbackId() {
        return buyerFeedbackId;
    }

    public void setBuyerFeedbackId(int buyerFeedbackId) {
        this.buyerFeedbackId = buyerFeedbackId;
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

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + buyerFeedbackId +
                ", date=" + date +
                ", time=" + time +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", response='" + response + '\'' +
                ", userId=" + buyerId +
                ", staffId=" + staffId +
                '}';
    }
}
