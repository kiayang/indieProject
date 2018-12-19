package edu.kyang.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * The type User event bean.
 */
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
    @ManyToOne
    @JoinColumn(name="ue_userid")
    private UserBean userBean;

    @ManyToOne
    @JoinColumn(name="ue_eventid")
    private EventBean eventBean;

    /**
     * The Ue paid status.
     */
    @Column(name="paid_status")
    String uePaidStatus;

    /**
     * The Ue paid date.
     */
    @Column(name="paid_date")
    LocalDate uePaidDate;

    /**
     * Instantiates a new User event bean.
     */
    public UserEventBean() {
    }

    /**
     * Instantiates a new User event bean.
     *
     * @param userBean     the user bean
     * @param eventBean    the event bean
     * @param uePaidStatus the ue paid status
     * @param uePaidDate   the ue paid date
     */
    public UserEventBean(UserBean userBean, EventBean eventBean, String uePaidStatus, LocalDate uePaidDate) {
        this.userBean = userBean;
        this.eventBean = eventBean;
        this.uePaidStatus = uePaidStatus;
        this.uePaidDate = uePaidDate;
    }

    /**
     * Instantiates a new User event bean.
     *
     * @param id           the id
     * @param userBean     the user bean
     * @param eventBean    the event bean
     * @param uePaidStatus the ue paid status
     * @param uePaidDate   the ue paid date
     */
//Needed for Junit testing
    public UserEventBean(int id, UserBean userBean, EventBean eventBean, String uePaidStatus, LocalDate uePaidDate) {
        this.ueId = id;
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

