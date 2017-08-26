package lv.javaguru.Domain;

import javax.persistence.*;


public class ConvMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int message_id;
    private String text;
    private int date;

    @OneToOne
    @JoinColumn(name = "conv_id")
    private Conversation conversation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ConvMessage() {
    }

    public ConvMessage(String text, int date, Conversation conversation, User user) {
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
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
