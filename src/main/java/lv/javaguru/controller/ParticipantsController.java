package lv.javaguru.controller;

import lv.javaguru.Businesslogic.ParticipantsService;
import lv.javaguru.Domain.Participants;
import lv.javaguru.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/participant")
public class ParticipantsController {

    @Autowired
    private ParticipantsService participantsService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addParticipant(@RequestBody Participants participants) {
        participantsService.addParticipant(participants);
    }

    @RequestMapping(value = "/delete/{part_id}", method = RequestMethod.POST)
    public void deleteParticipant(@PathVariable int part_id) {
        participantsService.deleteParticipant(part_id);
    }

    @RequestMapping(value = "/load/{conv_id}")
    public List<Participants> loadParticipantsOfConv(@PathVariable int conv_id) {
        return participantsService.loadParticipantsOfConv(conv_id);
    }

}
