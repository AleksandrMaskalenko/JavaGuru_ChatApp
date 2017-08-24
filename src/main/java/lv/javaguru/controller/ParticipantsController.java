package lv.javaguru.controller;

import lv.javaguru.Businesslogic.ParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/participant")
public class ParticipantsController {

    @Autowired
    private ParticipantsService participantsService;

    @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    public void addParticipant(@PathVariable int id) {
        participantsService.addParticipant(id);
    }

    @RequestMapping(value = "/delete/{id}")
    public void deleteParticipant(@PathVariable int id) {
        participantsService.deleteParticipant(id);
    }

}
