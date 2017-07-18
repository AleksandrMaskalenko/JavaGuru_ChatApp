package lv.javaguru.Commands;

import lv.javaguru.Domain.User;

import java.util.List;


public interface UserDAO {
    boolean addUser(String userName, int phone, String email);
    User getUser(String userName);


    List<User> findUser();
    void saveUser();
    List<User> getAllUsers();
}
