package lv.javaguru.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int conv_id;
    private String title;
    private int creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "part_id")
    private Participants participants;

    public Conversation() {
    }

    public Conversation(String title, int creationDate, User user, Participants participants) {
        this.title = title;
        this.creationDate = creationDate;
        this.user = user;
        this.participants = participants;
    }

    public int getConv_id() {
        return conv_id;
    }

    public void setConv_id(int conv_id) {
        this.conv_id = conv_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Participants getParticipants() {
        return participants;
    }

    public void setParticipants(Participants participants) {
        this.participants = participants;
    }
}
