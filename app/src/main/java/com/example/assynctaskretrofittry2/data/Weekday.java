package com.example.assynctaskretrofittry2.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weekday{
    @SerializedName("date")
    @Expose
    public Date date;
    @SerializedName("observed")
    @Expose
    public Observed observed;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Observed getObserved() {
        return observed;
    }

    public void setObserved(Observed observed) {
        this.observed = observed;
    }
}