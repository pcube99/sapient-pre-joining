package com.sapient.meetingService;

import com.sapient.meetingService.Meeting;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
public class MeetingService {
    ArrayList<Meeting> meetings = new ArrayList<Meeting>();

    public MeetingService() {
        meetings.add(Meeting.builder().meetingId(101).topic("Games").startTime("1000").endTime("1200").build());
        meetings.add(Meeting.builder().meetingId(102).topic("Web Dev").startTime("1300").endTime("1330").build());
        meetings.add(Meeting.builder().meetingId(103).topic("IOS").startTime("1600").endTime("1700").build());
        meetings.add(Meeting.builder().meetingId(104).topic("App Dev").startTime("1800").endTime("1900").build());
        meetings.add(Meeting.builder().meetingId(105).topic("COVID-19").startTime("0100").endTime("0500").build());
    }

    public ArrayList<Meeting> getAllMeetings() {
        return meetings;
    }

    public Meeting getMeetingById(int mId) {
        for(Meeting meeting : meetings) {
            if(meeting.getMeetingId() == mId) {
                return meeting;
            }
        }
        return Meeting.builder().meetingId(-1).topic("no meeting with this id").startTime("").endTime("").build();
    }
}
