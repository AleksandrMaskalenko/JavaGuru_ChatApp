package lv.javaguru.DAO;

import lv.javaguru.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

   //boolean addUser(String userName, int phone, String email);
    //boolean getUser(String userName);
    //List<User> findUser();
    //void saveUser();
    //List<User> getAllUsers();

}
