package lv.javaguru.Businesslogic;

import lv.javaguru.DAO.FriendListDAO;
import lv.javaguru.Domain.FriendList;
import lv.javaguru.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendListService {

    @Autowired
    private FriendListDAO friendListDAO;

    public FriendList getFriend(int id) {
        return friendListDAO.findOne(id);
    }

    public List<FriendList> getAllFriends() {
        return friendListDAO.findAll();

    }

    public void deleteFriend(int id) {
        friendListDAO.delete(id);
    }

    public void addFried(FriendList friendList) {
        friendListDAO.save(friendList);
    }

    public List<FriendList> getAllUserFriends(int id) {
        return friendListDAO.findUserFriends(id);
    }
}
