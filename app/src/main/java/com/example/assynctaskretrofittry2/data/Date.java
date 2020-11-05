package com.example.assynctaskretrofittry2.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Date{
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("numeric")
    @Expose
    public String numeric;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumeric() {
        return numeric;
    }

    public void setNumeric(String numeric) {
        this.numeric = numeric;
    }
}