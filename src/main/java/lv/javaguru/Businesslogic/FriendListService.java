package lv.javaguru.Businesslogic;

import lv.javaguru.DAO.FriendListDAO;
import lv.javaguru.DAO.UserDAO;
import lv.javaguru.Domain.FriendList;
import lv.javaguru.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendListService {

    @Autowired
    private FriendListDAO friendListDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    public FriendList getFriend(int id) {
        return friendListDAO.findOne(id);
    }

    public List<FriendList> getAllFriends() {
        return friendListDAO.findAll();

    }

    public void deleteFriend(int id) {
        friendListDAO.delete(id);
    }

    public void addFried(int id) {
        User user = userService.authentication();

        FriendList friendList = new FriendList();
        friendList.setMainUser_id(user.getId());
        friendList.setUser(userDAO.findOne(id));
        friendListDAO.save(friendList);
    }

    public List<FriendList> getAllUserFriends(int id) {
        return friendListDAO.findUserFriends(id);
    }
}
