package lv.javaguru.DAO;

import lv.javaguru.Domain.ConvMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ConvMessageDAO extends JpaRepository<ConvMessage, Integer> {

    @Query("SELECT m FROM ConvMessage m WHERE m.conversation.conv_id LIKE :conv_id")
    List<ConvMessage> getMessages(@Param("conv_id") int conv_id);

    @Modifying
    @Transactional
    @Query("DELETE FROM ConvMessage c WHERE c.conversation.conv_id LIKE :conv_id")
    void deleteAllByConvId(@Param("conv_id") int conv_id);
}
