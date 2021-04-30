package dev.granville.beans;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "email")
public class Email implements Comparable<Email> {

    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_id")
    private Integer emailId;
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private Employee Recipient;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Employee Sender;
    private String context;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }

    public void setSentTime(LocalDateTime sentTime) {
        this.sentTime = sentTime;
    }

    private LocalDateTime sentTime;

    public Employee getRecipient() {
        return Recipient;
    }

    public void setRecipient(Employee recipient) {
        Recipient = recipient;
    }

    public Employee getSender() {
        return Sender;
    }

    public void setSender(Employee sender) {
        Sender = sender;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public int compareTo(@NotNull Email o) {
        return this.sentTime.compareTo(o.sentTime);
    }
}
