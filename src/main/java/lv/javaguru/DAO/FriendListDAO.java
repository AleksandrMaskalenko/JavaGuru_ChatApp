package lv.javaguru.DAO;

import lv.javaguru.Domain.FriendList;
import lv.javaguru.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendListDAO extends JpaRepository<FriendList, Integer> {

   /* void addFriend(User user);
    void deleteFriend(int id);
    List<FriendList> getAllFriends(int id);*/
}
