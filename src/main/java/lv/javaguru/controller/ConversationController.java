package lv.javaguru.controller;

import lv.javaguru.Businesslogic.ConversationService;
import lv.javaguru.Domain.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/conversation")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createConversation(@RequestBody Conversation conversation) {
        conversationService.createConversation(conversation);
    }

    @RequestMapping(value = "/deleteconv/{conv_id}")
    public void deleteConversation(@PathVariable int conv_id) {
        conversationService.deleteConversation(conv_id);
    }

    @RequestMapping(value = "/userconv/{user_id}")
    public List<Conversation> getUserConversation(@PathVariable int user_id) {
        return conversationService.getUserConversations(user_id);
    }

}
