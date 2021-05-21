package com.ericsson.workfromhomeconcept.utils;

public class TimerSettings {

    private static TimerSettings timerSettings;

    private long activityTimerInMillis = 5000;
    private long snoozeTimer = 600000;

    private TimerSettings() {}

    public static TimerSettings getInstance() {
        if (timerSettings == null) {
            timerSettings = new TimerSettings();
        }
        return timerSettings;
    }

    public long getActivityTimerInMillis() {
        return activityTimerInMillis;
    }

    public void setActivityTimerInMillis(long activityTimerInMillis) {
        this.activityTimerInMillis = activityTimerInMillis;
    }

    public long getSnoozeTimer() {
        return snoozeTimer;
    }

    public void setSnoozeTimer(long snoozeTimer) {
        this.snoozeTimer = snoozeTimer;
    }
}
