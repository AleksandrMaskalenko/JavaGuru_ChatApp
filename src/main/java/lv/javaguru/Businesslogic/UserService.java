package lv.javaguru.Businesslogic;

import lv.javaguru.DAO.FriendListDAO;
import lv.javaguru.DAO.RoleDAO;
import lv.javaguru.DAO.UserDAO;
import lv.javaguru.Domain.FriendList;
import lv.javaguru.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    public User getUserById(int id) {
        return userDAO.findOne(id);
    }

    public void saveUser(User user) {
        user.setRole(roleDAO.findOne(2));
        userDAO.save(user);
    }

    public void deleteUser(int id) {


    }

    public List<User> findUser(String username) {return userDAO.findUserByName(username);}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findOneByUsername(username);
    }

    public User authentication() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        return userDAO.findOneByUsername(loggedUsername);
    }

    public void logout() {
        SecurityContextHolder.clearContext();
    }
}
