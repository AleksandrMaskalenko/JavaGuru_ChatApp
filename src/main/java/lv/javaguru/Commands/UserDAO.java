package lv.javaguru.Commands;

import lv.javaguru.Domain.User;

import java.util.List;


public interface UserDAO {
    void addUser();
    User getUser();
    List<User> findUser();
    void saveUser();
}
