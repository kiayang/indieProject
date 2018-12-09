package edu.kyang.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "EventBean")
@Table(name = "event")
@Data
public class EventBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "event_id")
    private int event_id;
    private String description;
    private LocalDate event_date;
    private BigDecimal event_fee;

    //one to one bidirectional association - targets entity table contains the foreign key. *Source entity
    //must use mappedBy attribute to define the bidirectional one to one mapping
    /*
     * mappedBy = “user” - We use mappedBy attribute in the User entity to tell hibernate that the User
     * entity is not responsible for this relationship and It should look for a field named user in the
     * UserProfile entity to find the configuration for the JoinColumn/ForeignKey column.
     */
    //@JoinColumn(name = "userid", insertable = false, updatable = false)
    //@OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL,mappedBy = "user")
    //@OneToOne(mappedBy="userid", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    //private UserRoleBean userRole;

    public EventBean() {
    }

    public EventBean(String description, LocalDate event_date, BigDecimal event_fee) {
        this.description = description;
        this.event_date = event_date;
        this.event_fee = event_fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventBean eventBean = (EventBean) o;
        return event_id == eventBean.event_id &&
                Objects.equals(description, eventBean.description) &&
                Objects.equals(event_date, eventBean.event_date) &&
                Objects.equals(event_fee, eventBean.event_fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(event_id, description, event_date, event_fee);
    }

    @Override
    public String toString() {
        return "EventBean{" +
                "event_id=" + event_id +
                ", description='" + description + '\'' +
                ", event_date=" + event_date +
                ", event_fee=" + event_fee +
                '}';
    }
}
