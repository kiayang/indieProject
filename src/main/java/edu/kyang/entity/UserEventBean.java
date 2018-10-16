package edu.kyang.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "UserEventBean")
@Table(name = "user_event")
public class UserEventBean {
    @Column(name = "ue_userid")
    private int userid;
    @Column(name = "ue_eventid")
    private int eventid;
    @Column(name = "paid_status")
    private String paidStatus;
    @Column(name = "paid_date")
    private Date paidDate;

    public UserEventBean() {
    }

    public UserEventBean(String userid, int eventid, String paidStatus, Date paidDate) {
        this.userid = userid;
        this.eventid = eventid;
        this.paidStatus = paidStatus;
        this.paidDate = paidDate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }
    @Temporal(TemporalType.DATE)
    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    @Override
    public String toString() {
        return "UserEventBean{" +
                "userid='" + userid + '\'' +
                ", eventid=" + eventid +
                ", paidStatus='" + paidStatus + '\'' +
                ", paidDate=" + paidDate +
                '}';
    }
}
