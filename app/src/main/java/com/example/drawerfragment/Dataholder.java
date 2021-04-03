package com.example.drawerfragment;

public class Dataholder {

    String contestName,contestVenue,contestFee;

    public Dataholder(String contestName, String contestVenue, String contestFee) {
        this.contestName = contestName;
        this.contestVenue = contestVenue;
        this.contestFee = contestFee;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getContestVenue() {
        return contestVenue;
    }

    public void setContestVenue(String contestVenue) {
        this.contestVenue = contestVenue;
    }

    public String getContestFee() {
        return contestFee;
    }

    public void setContestFee(String contestFee) {
        this.contestFee = contestFee;
    }
}
