package lv.javaguru.Domain;

import javax.persistence.*;

@Entity
@Table(name = "conversation")
public class Conversation {

    @Id
    @Column(name = "conv_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int conv_id;

    @Column(name = "title")
    private String title;

    @Column(name = "creation_date")
    private String creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Conversation() {
    }

    public Conversation(String title, String creationDate, User user) {
        this.title = title;
        this.creationDate = creationDate;
        this.user = user;
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
