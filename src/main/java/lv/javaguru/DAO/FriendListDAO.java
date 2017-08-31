package lv.javaguru.DAO;

import lv.javaguru.Domain.FriendList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FriendListDAO extends JpaRepository<FriendList, Integer> {

    @Query("SELECT f FROM FriendList f WHERE f.mainUser_id LIKE :id")
    List<FriendList> findUserFriends(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM FriendList f WHERE f.mainUser_id LIKE :user_id")
    void deleteUserFriends(@Param("user_id") int conv_id);

//    @Modifying
//    @Transactional
//    @Query("DELETE FROM FriendList f WHERE f.user.id LIKE :user_id")
//    void deleteAllFriends(@Param("user_id") int user_id);

}
