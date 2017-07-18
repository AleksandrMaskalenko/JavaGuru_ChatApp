package lv.javaguru.database;


import lv.javaguru.Domain.User;

import java.util.List;
import java.util.Optional;

public interface Database {
    void addUser(User user);

    void deleteUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserByUserName(String UserName);

}
