package witchub.com.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class VerificationToken {
    private static final int EXPIRATION = 60*24;

    private int id;
    private String token;
    private User user;
    private Date createdDate;
    private Date expiryDate;

    public static int getEXPIRATION() {
        return EXPIRATION;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(calendar.getTime().getTime()));
        calendar.add(Calendar.MINUTE,expiryTimeInMinutes);
        return new Date(calendar.getTime().getTime());
    }

    public VerificationToken(String token, User user) {
        this.token = token;
        this.user = user;
        Calendar calendar = Calendar.getInstance();
        this.createdDate = new Date(calendar.getTime().getTime());
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    public VerificationToken() {
    }
}
