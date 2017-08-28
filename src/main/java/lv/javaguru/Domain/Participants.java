package lv.javaguru.Domain;

import javax.persistence.*;

@Entity
@Table(name = "participants")
public class Participants {

    @Id
    @Column(name = "part_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int part_id;

    @ManyToOne
    @JoinColumn(name = "conv_id")
    private Conversation conversation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Participants() {
    }

    public Participants(Conversation conversation, User user) {
        this.conversation = conversation;
        this.user = user;
    }

    public int getPart_id() {
        return part_id;
    }

    public void setPart_id(int part_id) {
        this.part_id = part_id;
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
