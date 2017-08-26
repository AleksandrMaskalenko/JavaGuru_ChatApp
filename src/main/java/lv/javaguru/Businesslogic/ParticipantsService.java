package lv.javaguru.Businesslogic;

import lv.javaguru.DAO.ParticipantsDAO;
import lv.javaguru.Domain.Participants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantsService {

    @Autowired
    private ParticipantsDAO participantsDAO;

    public void addParticipant(int id) {

//        Participants participants = new Participants();
//        participants.setUser_id(id);

//        participantsDAO.save(participants);
    }

    public void deleteParticipant(int id) {
        participantsDAO.deleteUserFromParticipants(id);
    }
}
