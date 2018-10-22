package edu.kyang.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "UserBean")
@Table(name = "user")
@Data
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
    // '@EqualsAndHashCode'  - part of lombok to exclude from equals and hashcode
    private String zipcode;
    // 'ToString.Exclude' - add this code to exclude from ToString
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
