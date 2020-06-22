package com.sapient.participant.services;

import com.sapient.participant.models.Participants;
import java.util.ArrayList;

public class ParticipantService {
    ArrayList<Participants> participants = new ArrayList<Participants>();

    public ParticipantService() {
        participants.add(Participants.builder().pId(1).pName("Pankil").meetingId(101).build());
        participants.add(Participants.builder().pId(2).pName("Harsh").meetingId(102).build());
        participants.add(Participants.builder().pId(3).pName("Havya").meetingId(103).build());
        participants.add(Participants.builder().pId(4).pName("Sanjay").meetingId(104).build());
        participants.add(Participants.builder().pId(5).pName("Dhrumil").meetingId(104).build());
        participants.add(Participants.builder().pId(6).pName("Jeet").meetingId(105).build());
        participants.add(Participants.builder().pId(7).pName("Jaimin").meetingId(104).build());
    }

    public ArrayList<Participants> getAllparticipants(){
        return participants;
    }

    public ArrayList<Participants> getParticipantsByMeetingId(int mId) {
        ArrayList<Participants> pList = new ArrayList<Participants>();
        for(Participants p : participants) {
            if(p.getMeetingId() == mId) {
                pList.add(p);
            }
        }
        return pList;
    }

    public Participants getParticipantById(int pId) {
        for(Participants p : participants) {
            if(p.getPId() == pId) {
                return p;
            }
        }
        return Participants.builder().pId(-1).pName("---").meetingId(-1).build();
    }


}
