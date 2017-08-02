package lv.javaguru.DAO;

import lv.javaguru.Domain.Participants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantsDAO extends JpaRepository<Participants, Integer>{
}
