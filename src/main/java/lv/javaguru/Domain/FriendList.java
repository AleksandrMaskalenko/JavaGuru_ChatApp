package lv.javaguru.Domain;

import javax.persistence.*;

@Entity
@Table(name = "friend_list")
public class FriendList {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "main_user_id")
    private int mainUser_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public FriendList() {
    }

    public FriendList(int mainUser_id, User user) {
        this.mainUser_id = mainUser_id;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMainUser_id() {
        return mainUser_id;
    }

    public void setMainUser_id(int mainUser_id) {
        this.mainUser_id = mainUser_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
