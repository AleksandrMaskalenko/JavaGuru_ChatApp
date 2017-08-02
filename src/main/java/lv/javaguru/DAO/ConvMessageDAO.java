package lv.javaguru.DAO;

import lv.javaguru.Domain.ConvMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvMessageDAO extends JpaRepository<ConvMessage, Integer> {
}
