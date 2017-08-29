package lv.javaguru.DAO;

import lv.javaguru.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.username LIKE CONCAT('%',:username,'%')")
    List<User> findUserByName(@Param("username") String username);


    User findOneByUsername(String username);
}
