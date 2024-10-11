package org.application.notecalendardesktop.client;

import java.time.LocalDate;

public class Note {

    private LocalDate localDate = null;
    private String name = null;
    private String description = null;
    private boolean isTimeIncluded = false;
    private int hours = 0;
    private int minutes = 0;

    /* private boolean isRegular = false;
    private int yearRegularity = 0;
    private int monthRegularity = 0;
    private int dayRegularity = 0;
    private int hourRegularity = 0;
    private int minuteRegularity = 0; */

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimeIncluded(boolean timeIncluded) {
        isTimeIncluded = timeIncluded;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isTimeIncluded() {
        return isTimeIncluded;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}
