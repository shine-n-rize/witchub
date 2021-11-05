package witchub.com.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class Staff {

    @NotNull
    private int staffId;

    @NotBlank
    private String gender;

    @NotEmpty
    private Date dateOfBirth;

    private String type;
    private Date joinDate;
    private Date endDate;

    // foreign key(s)
    private int userId;

    public Staff(int staffId, String gender, Date dateOfBirth, String type, Date joinDate, Date endDate, int userId) {
        this.staffId = staffId;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.type = type;
        this.joinDate = joinDate;
        this.endDate = endDate;
        this.userId = userId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", type='" + type + '\'' +
                ", joinDate=" + joinDate +
                ", endDate=" + endDate +
                ", userId=" + userId +
                '}';
    }
}
