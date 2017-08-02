package lv.javaguru.Domain;

import javax.persistence.Entity;

@Entity
public class FriendList {

    private int user_id;
    private int friend_id;

    public FriendList() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }
}
