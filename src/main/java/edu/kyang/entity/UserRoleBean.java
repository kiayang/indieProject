package edu.kyang.entity;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

/**
 * The type User role bean.
 */
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
    private UserBean userBean;

    private String username;

    @Column(name = "role")
    private String userRole;

    /**
     * Instantiates a new User role bean.
     */
    public UserRoleBean() {
    }

    /**
     * Instantiates a new User role bean.
     *
     * @param userBean the user bean
     * @param username the username
     * @param userRole the user role
     */
    public UserRoleBean(UserBean userBean, String username, String userRole) {
        this.userBean = userBean;
        this.username = username;
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleBean that = (UserRoleBean) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(userRole, that.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, userRole);
    }
}
