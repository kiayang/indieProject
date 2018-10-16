package edu.kyang.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "EventBean")
@Table(name = "event")
public class EventBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int eventid;
    private String description;

    @Column(name = "event_date")
    private Date eventDate;
    @Column(name = "event_fee")
    private double eventFee;

    public EventBean() {
    }

    public EventBean(int eventid, String description, Date eventDate, double eventFee) {
        this.eventid = eventid;
        this.description = description;
        this.eventDate = eventDate;
        this.eventFee = eventFee;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.DATE)
    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public double getEventFee() {
        return eventFee;
    }

    public void setEventFee(double eventFee) {
        this.eventFee = eventFee;
    }

    @Override
    public String toString() {
        return "EventBean{" +
                "eventid=" + eventid +
                ", description='" + description + '\'' +
                ", eventDate=" + eventDate +
                ", eventFee=" + eventFee +
                '}';
    }
}
