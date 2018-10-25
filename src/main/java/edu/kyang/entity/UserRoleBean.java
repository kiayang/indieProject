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
    private int id;

    private int userid;

    private String username;

    @Column(name = "role")
    private String userRole;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private UserBean user;

    public UserRoleBean() {
    }

    public UserRoleBean(String username, String userRole, UserBean user) {
        this.username = username;
        this.userRole = userRole;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleBean that = (UserRoleBean) o;
        return id == that.id &&
                userid == that.userid &&
                Objects.equals(username, that.username) &&
                Objects.equals(userRole, that.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, username, userRole);
    }
}
