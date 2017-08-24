package lv.javaguru.controller;

import lv.javaguru.Businesslogic.ConversationService;
import lv.javaguru.Domain.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @RequestMapping(value = "/conversation/create", method = RequestMethod.POST)
    public void createConversation(@RequestBody Conversation conversation) {
        conversationService.createConversation(conversation);
    }

    @RequestMapping(value = "/deleteconv/{id}")
    public void deleteConversation(@PathVariable int id) {
        conversationService.deleteConversation(id);
    }

    @RequestMapping(value = "/findconv/{id}")
    public void findConversation(@PathVariable int id) {
        conversationService.findConversation(id);
    }
}
