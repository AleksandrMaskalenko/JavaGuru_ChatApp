package lv.javaguru.controller;

import lv.javaguru.Businesslogic.FriendListService;
import lv.javaguru.Domain.FriendList;
import lv.javaguru.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FriendsController {

    @Autowired
    private FriendListService friendListService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public List<User> getFriendList(@PathVariable int id) {
        return friendListService.getFriendList(id);
    }

    @RequestMapping(value = "/find/friend/{id}")
    public FriendList getFriend(@PathVariable int id) {
        return friendListService.getFriend(id);
    }

    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    public List<FriendList> getAllFriends() {
        return friendListService.getAllFriends();
    }
}
