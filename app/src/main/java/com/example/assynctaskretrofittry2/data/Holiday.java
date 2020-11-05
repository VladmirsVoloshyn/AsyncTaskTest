package com.example.assynctaskretrofittry2.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Holiday{
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("observed")
    @Expose
    public String observed;
    @SerializedName("public")
    @Expose
    public boolean rublic;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("uuid")
    @Expose
    public String uuid;
    @SerializedName("weekday")
    @Expose
    public Weekday weekday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getObserved() {
        return observed;
    }

    public void setObserved(String observed) {
        this.observed = observed;
    }

    public boolean isRublic() {
        return rublic;
    }

    public void setRublic(boolean rublic) {
        this.rublic = rublic;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }
}