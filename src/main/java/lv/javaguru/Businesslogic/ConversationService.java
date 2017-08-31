package lv.javaguru.Businesslogic;

import lv.javaguru.DAO.ConversationDAO;
import lv.javaguru.Domain.Conversation;
import lv.javaguru.Domain.Participants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConversationService {

    @Autowired
    private ConversationDAO conversationDAO;

    @Autowired
    private ParticipantsService participantsService;

    public void createConversation(Conversation conversation) {
        conversationDAO.save(conversation);
        participantsService.createParticipatsGroup(conversation);

    }

    public void deleteConversation(int id) {
        participantsService.deleteAllParticipants(id);
        conversationDAO.delete(id);
    }

    public List<Conversation> getUserConversations(int user_id) {
        List<Conversation> conversationList = new ArrayList<Conversation>();

        List<Participants> participantsList =  participantsService.getParticipatOfUserConver(user_id);

        for (Participants part: participantsList) {
            conversationList.add(conversationDAO.findOne(part.getConversation().getConv_id()));
        }

        return conversationList;
    }
}
