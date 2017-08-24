package lv.javaguru.controller;

import lv.javaguru.Businesslogic.ConvMessageService;
import lv.javaguru.Domain.ConvMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private ConvMessageService convMessageService;

    @RequestMapping(value = "/message/save", method = RequestMethod.POST)
    public void saveMessage(@RequestBody ConvMessage convMessage) {
        convMessageService.saveMassage(convMessage);
    }

    @RequestMapping(value = "/message/{id}")
    public List<ConvMessage> getMessages(@PathVariable int id) {
        return convMessageService.getMessages(id);
    }
}
