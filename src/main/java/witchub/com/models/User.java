package witchub.com.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class User {

    @NotNull
    private int userId;

    @NotEmpty
    private String username;    // remove

    @NotEmpty
    private String firstName;

    private String lastName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String phoneNo;

    private boolean status;

    private String role;
    private String password;
    private Date dateCreated;

    // address
    private String houseNo;
    private String street;
    private String city;

//    public User(int userId, String username, String firstName, String lastName, String email, String phoneNo, String status, String role, String password, LocalDateTime dateCreated, String houseNo, String street, String city) {
//        this.userId = userId;
//        this.username = username;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.phoneNo = phoneNo;
//        this.status = status;
//        this.role = role;
//        this.password = password;
//        this.dateCreated = dateCreated;
//        this.houseNo = houseNo;
//        this.street = street;
//        this.city = city;
//    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", status=" + status +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", dateCreated=" + dateCreated +
                ", houseNo='" + houseNo + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
