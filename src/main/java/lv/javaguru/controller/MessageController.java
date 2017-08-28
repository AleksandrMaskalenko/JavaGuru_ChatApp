package lv.javaguru.controller;

import lv.javaguru.Businesslogic.ConvMessageService;
import lv.javaguru.Domain.ConvMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    private ConvMessageService convMessageService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveMessage(@RequestBody ConvMessage convMessage) {
        convMessageService.saveMassage(convMessage);
    }

    @RequestMapping(value = "/load/{conv_id}")
    public List<ConvMessage> getMessages(@PathVariable int conv_id) {
        return convMessageService.getMessages(conv_id);
    }
}
