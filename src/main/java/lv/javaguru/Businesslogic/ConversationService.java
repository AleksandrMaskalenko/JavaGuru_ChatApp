package lv.javaguru.Businesslogic;

import lv.javaguru.DAO.ConversationDAO;
import lv.javaguru.DAO.ParticipantsDAO;
import lv.javaguru.Domain.Conversation;
import lv.javaguru.Domain.Participants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {

    @Autowired
    private ConversationDAO conversationDAO;

    @Autowired
    private ParticipantsDAO participantsDAO;

    public void createConversation(Conversation conversation) {
        Participants participants = new Participants();
        participantsDAO.save(participants);

        conversationDAO.save(conversation);
    }

    public void deleteConversation(int id) {
        conversationDAO.delete(id);
    }

    public void findConversation(int id) {
        conversationDAO.findConversation(id);
    }
}
