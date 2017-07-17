package lv.javaguru.Commands;

import lv.javaguru.Domain.Friends;

import java.util.List;


public interface FriendListDAO {

    void addFriend();
    void deleteFriend();
    List<Friends> getAllFriends();
}
