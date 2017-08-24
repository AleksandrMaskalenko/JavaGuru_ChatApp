package lv.javaguru.DAO;

import lv.javaguru.Domain.FriendList;
import lv.javaguru.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendListDAO extends JpaRepository<FriendList, Integer> {

    List<User> loadFriends(int id);

}
