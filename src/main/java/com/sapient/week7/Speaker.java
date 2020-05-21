package com.sapient.week7;

public class Speaker {
    private int vol_levels;
    private String speaker_type;

    public int getVol_levels() {
        return vol_levels;
    }

    public void setVol_levels(int vol_levels) {
        this.vol_levels = vol_levels;
    }

    public String getSpeaker_type() {
        return speaker_type;
    }

    public void setSpeaker_type(String speaker_type) {
        this.speaker_type = speaker_type;
    }

    public void checkSpeaker() {
        System.out.println("Speaker is initialized with vol_levels= " + getVol_levels() + " type= " + getSpeaker_type());
    }
}
