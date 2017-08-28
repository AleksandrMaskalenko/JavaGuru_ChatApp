package lv.javaguru.DAO;

import lv.javaguru.Domain.ConvMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConvMessageDAO extends JpaRepository<ConvMessage, Integer> {

    @Query("SELECT m FROM ConvMessage m WHERE m.conversation.conv_id LIKE :conv_id")
    List<ConvMessage> getMessages(@Param("conv_id") int conv_id);
}
