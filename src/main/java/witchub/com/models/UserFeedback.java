package witchub.com.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;

public class UserFeedback {

    @NotNull
    private int userFeedbackId;

    private Date date;
    private Time time;

    @NotEmpty
    private String subject;

    @NotEmpty
    private String message;

    private String response;

    // foreign key(s)
    private int userId;
    private int staffId;

    public UserFeedback(int feedbackId, Date date, Time time, String subject, String message, String response, int userId, int staffId) {
        this.userFeedbackId = feedbackId;
        this.date = date;
        this.time = time;
        this.subject = subject;
        this.message = message;
        this.response = response;
        this.userId = userId;
        this.staffId = staffId;
    }

    public int getUserFeedbackId() {
        return userFeedbackId;
    }

    public void setUserFeedbackId(int userFeedbackId) {
        this.userFeedbackId = userFeedbackId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
                "feedbackId=" + userFeedbackId +
                ", date=" + date +
                ", time=" + time +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", response='" + response + '\'' +
                ", userId=" + userId +
                ", staffId=" + staffId +
                '}';
    }
}
