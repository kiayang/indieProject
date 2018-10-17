package edu.kyang.entity;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "UserRoleBean")
@Table(name = "user_role")

public class UserRoleBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int roleId;
    private int userid;
    private String role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private UserBean user;

    public UserRoleBean() {
    }

    public UserRoleBean(int roleId, int userid, String role, UserBean user) {
        this.roleId = roleId;
        this.userid = userid;
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
    public String toString() {
        return "UserRoleBean{" +
                "roleId=" + roleId +
                ", userid=" + userid +
                ", role='" + role + '\'' +
                ", user=" + user +
                '}';
    }
}
