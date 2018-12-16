package edu.kyang.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "UserEventBean")
@Table(name = "user_event")
@Data
public class UserEventBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "ue_id")
    private int ueId;

    /*
    By default, the @ManyToOne association assumes that the parent-side entity identifier is to be used to join
    with the client-side entity Foreign Key column. However, when using a non-Primary Key association,
    the column description and foreign key should be used to instruct Hibernate which column should be used on
    the parent side to establish the many-to-one database relationship.
    Source: http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#associations-one-to-many
    *** Foreign key is on the child table
    */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ue_userid")
    private UserBean userBean;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ue_eventid")
    private EventBean eventBean;

    @Column(name="paid_status")
    String uePaidStatus;

    @Column(name="paid_date")
    LocalDate uePaidDate;

    public UserEventBean() {
    }

    public UserEventBean(UserBean userBean, EventBean eventBean, String uePaidStatus, LocalDate uePaidDate) {
        this.userBean = userBean;
        this.eventBean = eventBean;
        this.uePaidStatus = uePaidStatus;
        this.uePaidDate = uePaidDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEventBean that = (UserEventBean) o;
        return ueId == that.ueId &&
                Objects.equals(uePaidStatus, that.uePaidStatus) &&
                Objects.equals(uePaidDate, that.uePaidDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ueId, uePaidStatus, uePaidDate);
    }

    @Override
    public String toString() {
        return "UserEventBean{" +
                "ueId=" + ueId +
                ", userBean=" + userBean +
                ", eventBean=" + eventBean +
                ", uePaidStatus='" + uePaidStatus + '\'' +
                ", uePaidDate=" + uePaidDate +
                '}';
    }
}

