package lv.javaguru.DAO;

import lv.javaguru.Domain.Conversation;
import lv.javaguru.Domain.Participants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ParticipantsDAO extends JpaRepository<Participants, Integer>{

    @Query("SELECT p FROM Participants p WHERE p.user.id LIKE :id")
    List<Participants> getPart(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Participants p WHERE p.conversation.conv_id LIKE :conv_id")
    void deleteAllParticipants(@Param("conv_id") int conv_id);

    @Query("SELECT p FROM Participants p WHERE p.conversation.conv_id LIKE :conv_id")
    List<Participants> loadParticipantsOfConv(@Param("conv_id") int conv_id);
}
