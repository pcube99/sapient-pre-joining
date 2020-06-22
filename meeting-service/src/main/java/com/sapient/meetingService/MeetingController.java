package com.sapient.meetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MeetingController {
    @Autowired
    private ParticipantServiceProxy participantServiceProxy;

    @GetMapping("/meetings")
    public ArrayList<Meeting> allMeetings() {
        return new MeetingService().getAllMeetings();
    }

    @GetMapping("/meeting/{mid}")
    public Meeting meetingWithId(@PathVariable int mid) {
        Meeting m = new MeetingService().getMeetingById(mid);
        return m;
    }

    @GetMapping("/meeting/{id}/participants")
    public ArrayList<Participant> getAllParticipants(@PathVariable int id) {

        ArrayList<Participant> response = participantServiceProxy.allParticipants();
        ArrayList<Participant> output = new ArrayList<Participant>();
        for(Participant p : response) {
            if(p.getMeetingId() == id) {
                output.add(p);
            }
        }
        return output;
    }

    @GetMapping("/meeting/{id}/participants/try")
    public ArrayList<Participant> getAllParticipantsTry(@PathVariable int id) {
        ArrayList<Participant> response = participantServiceProxy.participantsForMeetingById(id);
        return response;
    }

}
