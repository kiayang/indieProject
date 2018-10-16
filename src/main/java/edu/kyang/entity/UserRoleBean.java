package edu.kyang.entity;

import javax.persistence.*;

@Entity(name = "UserRoleBean")
@Table(name = "user_role")

public class UserRoleBean {
    @Id
    @Column(name = "role_id")
    private int userid;
    private String role;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "userid")
    @MapsId
    private UserBean user;

    public UserRoleBean() {
    }

    public UserRoleBean(int userid, String role, UserBean user) {
        this.userid = userid;
        this.role = role;
        this.user = user;
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
                "userid=" + userid +
                ", role='" + role + '\'' +
                ", user=" + user +
                '}';
    }
}
