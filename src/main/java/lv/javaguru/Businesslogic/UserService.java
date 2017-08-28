package lv.javaguru.Businesslogic;

import lv.javaguru.DAO.RoleDAO;
import lv.javaguru.DAO.UserDAO;
import lv.javaguru.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User getUserById(int id) {
        return userDAO.findOne(id);
    }

    public void saveUser(User user) {
        userDAO.save(user);
    }

    public void deleteUser(int id) {
        userDAO.delete(id);
    }

    public List<User> findUser(String userName) {return userDAO.findUserByName(userName);}

   // public List<User> createUser { User user = new User()}
}
