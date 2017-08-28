package lv.javaguru.Businesslogic;

import lv.javaguru.DAO.ConversationDAO;
import lv.javaguru.DAO.ParticipantsDAO;
import lv.javaguru.DAO.UserDAO;
import lv.javaguru.Domain.Conversation;
import lv.javaguru.Domain.Participants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantsService {

    @Autowired
    private ParticipantsDAO participantsDAO;

    @Autowired
    private ConversationDAO conversationDAO;

    @Autowired
    private UserDAO userDAO;

    public void createParticipatsGroup(Conversation conversation) {

        Participants participants = new Participants();
        participants.setConversation(conversationDAO.findOneByConvTitle(conversation.getTitle()));
        participants.setUser(userDAO.findOne(conversation.getUser().getId()));

        participantsDAO.save(participants);

    }

    public List<Participants> getParticipatOfUserConver (int id) {
        return participantsDAO.getPart(id);
    }

    public void deleteAllParticipants(int id) {
        participantsDAO.deleteAllParticipants(id);
    }



    public void addParticipant(Participants participants) {
        participantsDAO.save(participants);
    }

    public void deleteParticipant(int part_id) {
        participantsDAO.delete(part_id);
    }

    public List<Participants> loadParticipantsOfConv(int conv_id) {
        return participantsDAO.loadParticipantsOfConv(conv_id);
    }
}
