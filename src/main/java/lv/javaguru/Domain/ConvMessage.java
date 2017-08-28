package lv.javaguru.Domain;

import javax.persistence.*;

@Entity
@Table(name = "conv_message")
public class ConvMessage {

    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int message_id;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "conv_id")
    private Conversation conversation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ConvMessage() {
    }

    public ConvMessage(String text, String date, Conversation conversation, User users) {
        this.text = text;
        this.date = date;
        this.conversation = conversation;
        this.user = user;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
