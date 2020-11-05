package com.example.assynctaskretrofittry2.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Main {
    @SerializedName("status")
    @Expose
    public int status;
    @SerializedName("warning")
    @Expose
    public String warning;
    @SerializedName("requests")
    @Expose
    public Requests requests;
    @SerializedName("holidays")
    @Expose
    public ArrayList<Holiday> holidays = null;

    public ArrayList<Holiday> getHolidays() {
        return holidays;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public Requests getRequests() {
        return requests;
    }

    public void setRequests(Requests requests) {
        this.requests = requests;
    }

    public void setHolidays(ArrayList holidays) {
        this.holidays = holidays;
    }
}
