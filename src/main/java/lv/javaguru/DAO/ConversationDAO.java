package lv.javaguru.DAO;

import lv.javaguru.Domain.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationDAO extends JpaRepository<Conversation, Integer>{
}
