package lv.javaguru.database;


import com.google.common.collect.Lists;
import lv.javaguru.Domain.User;

import java.util.List;
import java.util.Optional;



public class DatabaseImpl implements Database {

    private List<User> users = Lists.newArrayList();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        return Lists.newArrayList(users);
    }


    @Override
    public Optional<User> getUserByUserName(String userName) {
        return users.stream()
                .filter(u -> u.getUserName().equals(userName))
                .findFirst();
    }

}
