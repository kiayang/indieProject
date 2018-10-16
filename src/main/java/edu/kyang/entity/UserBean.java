package edu.kyang.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "UserBean")
@Table(name = "user")

public class UserBean {
    @Id
    private int userid;
    private String username;
    @Column(name = "user_status")
    private String status;
    private String password;
    private String firstname;
    private String lastname;
    private String suffix;
    private Date dateofbirth;
    private String address;
    private String state;
    private String zipcode;
    private String phone;

    @OneToMany(mappedBy = "user", fetch = LAZY)
    private Set<UserEventBean> userEvents = new HashSet<>();

    //Mapping one to one relationship with same primary key unilateral
    @OneToOne(mappedBy = "userid")
    private UserRoleBean userRole;

    public UserBean() {
    }

    public UserBean(int userid, String username, String status, String password, String firstname, String lastname, String suffix, Date dateofbirth, String address, String state, String zipcode, String phone, Set<UserEventBean> userEvents, UserRoleBean userRole) {
        this.userid = userid;
        this.username = username;
        this.status = status;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.suffix = suffix;
        this.dateofbirth = dateofbirth;
        this.address = address;
        this.state = state;
        this.zipcode = zipcode;
        this.phone = phone;
        this.userEvents = userEvents;
        this.userRole = userRole;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    @Temporal(TemporalType.DATE)
    public Date getDateofbirth() {
        return dateofbirth;
    }
    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<UserEventBean> getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(Set<UserEventBean> userEvents) {
        this.userEvents = userEvents;
    }

    public UserRoleBean getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleBean userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", status='" + status + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", suffix='" + suffix + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", phone='" + phone + '\'' +

                '}';
    }
}
