package com.sapient.meetingService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
@Component
@FeignClient(name="participant-service", url="localhost:8100")
public interface ParticipantServiceProxy {
    @GetMapping("/participants/meeting/{id}")
    public ArrayList<Participant> participantsForMeetingById(@PathVariable int id);

    @GetMapping("/participants")
    public ArrayList<Participant> allParticipants();

}
