package edu.kyang.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "UserBean")
@Table(name = "user")

public class UserBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String username;
    @Column(name = "user_status")
    private String status;
    private String password;
    private String firstname;
    private String lastname;
    private String suffix;
    private LocalDate dateofbirth;
    private String address;
    private String state;
    private String zipcode;
    private String phone;

    //one to one bidirectional association - targets entity table contains the foreign key. *Source entity
    //must use mappedBy attribute to define the bidirectional one to one mapping
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserRoleBean userRole;

    public UserBean() {
    }

    public UserBean(int id, String username, String status, String password, String firstname, String lastname, String suffix, LocalDate dateofbirth, String address, String state, String zipcode, String phone) {
        this.id = id;
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
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return id;
    }

    public void setUserid(int id) {
        this.id = id;
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

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }
    public void setDateofbirth(LocalDate dateofbirth) {
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

    public UserRoleBean getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleBean userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
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
