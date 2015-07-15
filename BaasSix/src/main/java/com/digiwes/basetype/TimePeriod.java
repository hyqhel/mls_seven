package com.digiwes.basetype;

/**
 * A base / value business entity used to represent a period of time, between two time points
 */
public class TimePeriod {

    /**
     * An instant of time, starting at the TimePeriod
     * 
     * Notes:
     * If null, then represents to the beginning of time
     */
    public int startDateTime;
    /**
     * An instant of time, ending at the TimePeriod:
     * 
     * Notes:
     * If null, then represents to the end of time
     */
    public int endDateTime;

    public int getStartDateTime() {
        return this.startDateTime;
    }

    public void setStartDateTime(int startDateTime) {
        this.startDateTime = startDateTime;
    }

    public int getEndDateTime() {
        return this.endDateTime;
    }

    public void setEndDateTime(int endDateTime) {
        this.endDateTime = endDateTime;
    }

}