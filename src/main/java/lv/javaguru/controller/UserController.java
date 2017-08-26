package lv.javaguru.controller;

import lv.javaguru.Businesslogic.UserService;
import lv.javaguru.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @RequestMapping(value = "/find/{userName}")
    public List<User> findUser(@PathVariable String userName) {
        return userService.findUser(userName);
    }


}