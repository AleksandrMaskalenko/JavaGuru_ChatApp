package lv.javaguru.controller;

import lv.javaguru.Businesslogic.UserService;
import lv.javaguru.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @RequestMapping(value = "/delete/{id}",  method = RequestMethod.POST)
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @RequestMapping(value = "/find/{username}", method = RequestMethod.GET)
    public List<User> findUser(@PathVariable String username) {
        return userService.findUser(username);
    }

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}