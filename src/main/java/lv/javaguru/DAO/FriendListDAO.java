package lv.javaguru.DAO;

import lv.javaguru.Domain.FriendList;
import lv.javaguru.Domain.User;

import java.util.List;


public interface FriendListDAO {

    void addFriend(User user);
    void deleteFriend(int id);
    List<FriendList> getAllFriends(int id);
}
