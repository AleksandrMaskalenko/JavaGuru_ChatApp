package lv.javaguru.Businesslogic;

import lv.javaguru.Commands.UserDAO;
import lv.javaguru.Domain.User;
import lv.javaguru.database.Database;

import java.util.List;
import java.util.Optional;


public class UserService implements UserDAO {

    private Database dao;

    public UserService(Database dao) {
        this.dao = dao;
    }


    @Override
    public boolean addUser(String userName, int phone, String email) {
        User user = new User();
        user.setUserName(userName);
        user.setPhone(phone);
        user.setEmail(email);

        if (alreadyExists(user)) {
            return false;
        } else {
            dao.addUser(user);
            return true;

        }
    }

    @Override
    public User getUser(String userName) {
        Optional<User> foundUser = dao.getUserByUserName(userName);
        if (foundUser.isPresent()) {
            User user = foundUser.get();
            return user;
        }
        return null;/// ????????
    }

    @Override
    public List<User> findUser() {
        return null;
    }

    @Override
    public void saveUser() {

    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    private boolean alreadyExists(User user) {
        return dao.getUserByUserName(user.getUserName()).isPresent();
    }
}

