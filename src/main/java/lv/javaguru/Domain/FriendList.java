package lv.javaguru.Domain;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.List;


public class FriendList {

    @Id
    private int user_id;
    private int friends_id;

    public FriendList() {
    }

    public FriendList(int user_id, int friends_id) {
        this.user_id = user_id;
        this.friends_id = friends_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFriends_id() {
        return friends_id;
    }

    public void setFriends_id(int friends_id) {
        this.friends_id = friends_id;
    }
}
