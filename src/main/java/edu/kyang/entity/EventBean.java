package edu.kyang.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Event bean.
 */
@Entity(name = "EventBean")
@Table(name = "event")
@Data
public class EventBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "event_id")
    private int eventId;
    private String event_userid;
    private String description;
    private LocalDate event_date;
    private BigDecimal event_fee;

    /*
     The bidirectional @OneToMany association also requires a @ManyToOne association on the child side.
     Although the Domain Model exposes two sides to navigate this association, behind the scenes,
     the relational database has only one foreign key for this relationship.
     Every bidirectional association must have one owning side only (the child side),
     the other one being referred to as the inverse (or the mappedBy) side.
     */

    @OneToMany(mappedBy = "eventBean", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserEventBean> userEventList = new HashSet<>();

    /**
     * Instantiates a new Event bean.
     */
    public EventBean() {
    }

    /**
     * Instantiates a new Event bean.
     *
     * @param event_userid the event userid
     * @param description  the description
     * @param event_date   the event date
     * @param event_fee    the event fee
     */
    public EventBean(String event_userid, String description, LocalDate event_date, BigDecimal event_fee) {
        this.event_userid = event_userid;
        this.description = description;
        this.event_date = event_date;
        this.event_fee = event_fee;
    }

    @java.lang.Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        EventBean eventBean = (EventBean) object;
        return eventId == eventBean.eventId &&
                java.util.Objects.equals(event_userid, eventBean.event_userid) &&
                java.util.Objects.equals(description, eventBean.description) &&
                java.util.Objects.equals(event_date, eventBean.event_date) &&
                java.util.Objects.equals(event_fee, eventBean.event_fee);
    }

    @java.lang.Override
    public int hashCode() {
        return java.util.Objects.hash(eventId, event_userid, description, event_date, event_fee);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "EventBean{" +
                "eventId=" + eventId +
                ", event_userid='" + event_userid + '\'' +
                ", description='" + description + '\'' +
                ", event_date=" + event_date +
                ", event_fee=" + event_fee +
                '}';
    }
}
