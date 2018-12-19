package edu.kyang.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "UserBean")
@Table(name = "user")
@Data
public class UserBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "userid")
    private int id;
    private String username;
    @Column(name = "user_status")
    private String status;
    private String password;
    private String firstname;
    private String lastname;
    private String middlename;
    private LocalDate dateofbirth;
    private String address;
    private String state;
    // '@EqualsAndHashCode'  - part of lombok to exclude from equals and hashcode
    private String zipcode;
    // 'ToString.Exclude' - add this code to exclude from ToString
    private String phone;

    //one to one bidirectional association - targets entity table contains the foreign key. *Source entity
    //must use mappedBy attribute to define the bidirectional one to one mapping
    /*
     * mappedBy = “user” - We use mappedBy attribute in the User entity to tell hibernate that the User
     * entity is not responsible for this relationship and It should look for a field named user in the
     * UserProfile entity to find the configuration for the JoinColumn/ForeignKey column.
     */
    @OneToOne(mappedBy="userBean", orphanRemoval = true, fetch = FetchType.EAGER)
    private UserRoleBean userRole;

    @OneToMany(mappedBy = "userBean", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserEventBean> userEventList = new HashSet<>();

    public UserBean() {
    }

    public UserBean(String username, String status, String password, String firstname, String lastname, String middlename, LocalDate dateofbirth, String address, String state, String zipcode, String phone) {
        this.username = username;
        this.status = status;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.dateofbirth = dateofbirth;
        this.address = address;
        this.state = state;
        this.zipcode = zipcode;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBean userBean = (UserBean) o;
        return id == userBean.id &&
                Objects.equals(username, userBean.username) &&
                Objects.equals(status, userBean.status) &&
                Objects.equals(password, userBean.password) &&
                Objects.equals(firstname, userBean.firstname) &&
                Objects.equals(lastname, userBean.lastname) &&
                Objects.equals(middlename, userBean.middlename) &&
                Objects.equals(dateofbirth, userBean.dateofbirth) &&
                Objects.equals(address, userBean.address) &&
                Objects.equals(state, userBean.state) &&
                Objects.equals(zipcode, userBean.zipcode) &&
                Objects.equals(phone, userBean.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, status, password, firstname, lastname, middlename, dateofbirth, address, state, zipcode, phone);
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
                ", middlename='" + middlename + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
