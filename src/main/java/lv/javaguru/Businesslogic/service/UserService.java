package lv.javaguru.Businesslogic.service;

import lv.javaguru.DAO.UserDAO;
import lv.javaguru.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService  {

    void save(User user);

    User findByUserName(String userName);

}

