package dev.granville.beans;

import javax.persistence.*;

@Entity
@Table(name = "reimbursement_eventtype")
public class ReimbursementEventType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventid")
    private Integer eventId;
    @Column(name = "eventname")
    private String eventName;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
