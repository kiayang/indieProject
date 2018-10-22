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
    @Column(name = "id")
    private int roleId;
    private int userid;
    private String username;
    private String role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    //@JoinColumn(name = "userid",
    //        foreignKey = @ForeignKey(name = "role_user_user_id_fk")

    private UserBean user;

    public UserRoleBean() {
    }

    public UserRoleBean(int userid, String username, String role, UserBean user) {
        this.userid = userid;
        this.username = username;
        this.role = role;
        this.user = user;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleBean that = (UserRoleBean) o;
        return roleId == that.roleId &&
                userid == that.userid &&
                Objects.equals(username, that.username) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, userid, username, role);
    }
}
