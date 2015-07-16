package com.digiwes.basetype;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A base / value business entity used to represent a period of time, between two time points
 */
public class TimePeriod {

    /**
     * An instant of time, starting at the TimePeriod
     * <p/>
     * Notes:
     * If null, then represents to the beginning of time
     */
    public Date startDateTime;
    /**
     * An instant of time, ending at the TimePeriod:
     * <p/>
     * Notes:
     * If null, then represents to the end of time
     */
    public Date endDateTime;

    public Date getStartDateTime() {
        return this.startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return this.endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public TimePeriod(String startDateTime, String endDateTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            if (StringUtils.isNotEmpty(startDateTime)) {
                this.startDateTime = format.parse(startDateTime);
            }
            if (StringUtils.isNotEmpty(endDateTime)) {
                this.endDateTime = format.parse(endDateTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public TimePeriod() {
    }


    /**
     * 0  表示在区间
     * -1 小于开始时间
     * 1  大于结束时间
     *
     * @param time
     * @return
     */
    public int isInTimePeriod(Date time) {
        if (this.startDateTime != null && this.endDateTime != null) {
            if (time.compareTo(this.startDateTime) == 1 && time.compareTo(this.endDateTime) == -1) {
                return 0;
            } else if (time.compareTo(this.startDateTime) == -1) {
                return -1;
            } else if (time.compareTo(this.endDateTime) == 1) {
                return 1;
            }
        }
        return 0;
    }

    public boolean isOverlap(TimePeriod validFor) {
        if (validFor.getStartDateTime().compareTo(endDateTime) <= 0 && validFor.endDateTime.compareTo(startDateTime) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimePeriod that = (TimePeriod) o;

        if (startDateTime != null ? !startDateTime.equals(that.startDateTime) : that.startDateTime != null)
            return false;
        return !(endDateTime != null ? !endDateTime.equals(that.endDateTime) : that.endDateTime != null);

    }

    @Override
    public int hashCode() {
        int result = startDateTime != null ? startDateTime.hashCode() : 0;
        result = 31 * result + (endDateTime != null ? endDateTime.hashCode() : 0);
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String, String> vaildFor = new HashMap<String, String>();
        vaildFor.put("startDateTime", this.startDateTime == null ? "" : format.format(this.startDateTime));
        vaildFor.put("endDateTime", this.endDateTime == null ? "" : format.format(this.endDateTime));
        return vaildFor.toString();
    }
}