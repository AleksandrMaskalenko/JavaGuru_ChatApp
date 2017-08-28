package lv.javaguru.DAO;

import lv.javaguru.Domain.FriendList;
import lv.javaguru.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendListDAO extends JpaRepository<FriendList, Integer> {

    @Query("SELECT f FROM FriendList f WHERE f.mainUser_id LIKE :id")
    List<FriendList> findUserFriends(@Param("id") int id);

}
