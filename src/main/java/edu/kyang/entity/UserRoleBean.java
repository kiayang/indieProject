package edu.kyang.entity;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity(name = "UserRoleBean")
@Table(name = "user_role")
@Data
public class UserRoleBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "role_id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userid")
    private UserBean userid;

    private String username;

    @Column(name = "role")
    private String userRole;

    /*
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)*/
    //private UserBean user;

    public UserRoleBean() {
    }

    public UserRoleBean(UserBean userid, String username, String userRole) {
        this.userid = userid;
        this.username = username;
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleBean that = (UserRoleBean) o;
        return id == that.id &&
                userid == that.userid &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, username);
    }
}
