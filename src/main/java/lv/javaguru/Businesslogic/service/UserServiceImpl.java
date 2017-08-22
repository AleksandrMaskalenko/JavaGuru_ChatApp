package lv.javaguru.Businesslogic.service;

import lv.javaguru.DAO.RoleDAO;
import lv.javaguru.DAO.UserDAO;
import lv.javaguru.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bccrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

   //private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {

    }

    @Override
    public User findByUserName(String userName) {
        return null;
    }
}
