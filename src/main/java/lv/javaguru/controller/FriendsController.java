package lv.javaguru.controller;

import lv.javaguru.Businesslogic.FriendListService;
import lv.javaguru.Domain.FriendList;
import lv.javaguru.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/friend")
public class FriendsController {

    @Autowired
    private FriendListService friendListService;

    @RequestMapping(value = "/find/{id}")
    public FriendList getFriend(@PathVariable int id) {
        return friendListService.getFriend(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void deleteFriend(@PathVariable int id) {
        friendListService.deleteFriend(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addFriend(@RequestBody FriendList friendList) {
        friendListService.addFried(friendList);
    }

    @RequestMapping(value = "/userfriends/{id}")
    public List<FriendList> getAllUserFriends(@PathVariable int id) {
        return friendListService.getAllUserFriends(id);
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<FriendList> getAllFriends() {
        return friendListService.getAllFriends();
    }
}
