package dev.granville.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursement_urgency")
public class Urgency {


    @Id
    @Column(name="urgency_id")
    private Integer urgencyId;

    public String getUrgencyName() {
        return urgencyName;
    }

    @Column(name = "urgency")
    private String urgencyName;

    public Integer getUrgencyId() {
        return urgencyId;
    }

    public void setUrgencyId(Integer urgencyId) {
        this.urgencyId = urgencyId;
    }

}
