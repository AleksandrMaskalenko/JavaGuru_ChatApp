package lv.javaguru.Businesslogic;

import lv.javaguru.DAO.UserDAO;
import lv.javaguru.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  {

    @Autowired
    private UserDAO userDAO;

    /*private Database dao;

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
    public boolean getUser(String userName) {
        Optional<User> foundUser = dao.getUserByUserName(userName);
        if (foundUser.isPresent()) {
            User user = foundUser.get();
            return true;
        }
        return false;
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
    }*/
}

