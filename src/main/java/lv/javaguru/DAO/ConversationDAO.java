package lv.javaguru.DAO;

import lv.javaguru.Domain.Conversation;
import lv.javaguru.Domain.Participants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationDAO extends JpaRepository<Conversation, Integer>{

    @Query("SELECT c FROM Conversation c WHERE c.title LIKE :title")
    Conversation findOneByConvTitle(@Param("title")String title);
}
