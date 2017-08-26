package lv.javaguru.Domain;

import javax.persistence.*;
import java.util.List;


public class Participants {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int part_id;

    @OneToOne(mappedBy = "participants")
    private Conversation conversation;

    @OneToMany(mappedBy = "participants")
    private List<User> users;

    public Participants() {
    }

    public Participants(Conversation conversation, List<User> users) {
        this.conversation = conversation;
        this.users = users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
