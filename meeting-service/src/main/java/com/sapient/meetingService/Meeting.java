package com.sapient.meetingService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Meeting {
    private int meetingId;
    private String topic;
    private String startTime;
    private String endTime;

}
