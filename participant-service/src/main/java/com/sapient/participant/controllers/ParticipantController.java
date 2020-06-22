package com.sapient.participant.controllers;

import com.sapient.participant.models.Participants;
import com.sapient.participant.services.ParticipantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class ParticipantController {
    @GetMapping("check")
    public String healthCheck() {
        return "Server is running like Flash !!!";
    }

    @GetMapping("/participants")
    public ArrayList<Participants> allParticipants() {
        ArrayList<Participants> participants = new ParticipantService().getAllparticipants();
        return participants;
    }

    @GetMapping("/participant/{id}")
    public Participants meetingsForId(@PathVariable int id) {
        return new ParticipantService().getParticipantById(id);
    }

    @GetMapping("/participants/meeting/{id}")
    public ArrayList<Participants> participantsForMeetingById(@PathVariable int id) {
        return new ParticipantService().getParticipantsByMeetingId(id);
    }

}
