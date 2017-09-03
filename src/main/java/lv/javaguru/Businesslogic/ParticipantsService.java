package lv.javaguru.Businesslogic;

import lv.javaguru.DAO.ConversationDAO;
import lv.javaguru.DAO.ParticipantsDAO;
import lv.javaguru.DAO.UserDAO;
import lv.javaguru.Domain.Conversation;
import lv.javaguru.Domain.Participants;
import lv.javaguru.Domain.User;
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

    @Autowired
    private UserService userService;

    public void createParticipatsGroup(Conversation conversation) {

        User user1 = userDAO.findOne(conversation.getUser().getId());
        particip(conversation, user1);

        if (conversation.getConvType() == "pair") {
            User user2 = userDAO.findOneByUsername(conversation.getTitle());
            particip(conversation, user2);
        }

    }

    private void particip (Conversation conversation, User user) {
        Participants participants = new Participants();
        participants.setConversation(conversationDAO.findOneByConvTitle(conversation.getTitle()));
        participants.setUser(user);
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

    public void deletParticipByUserId(int conv_id) {
        User user = userService.authentication();

        List<Participants> partList = participantsDAO.loadParticipantsOfConv(conv_id);
        for (Participants partip : partList) {
            if (partip.getUser().getId() == user.getId()) {
                participantsDAO.delete(partip.getPart_id());
            }
        }

    }
}
