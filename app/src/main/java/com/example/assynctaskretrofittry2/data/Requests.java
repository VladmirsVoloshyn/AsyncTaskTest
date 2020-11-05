package com.example.assynctaskretrofittry2.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Requests{
    @SerializedName("used")
    @Expose
    public int used;
    @SerializedName("available")
    @Expose
    public int available;
    @SerializedName("reset")
    @Expose
    public String resets;

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getResets() {
        return resets;
    }

    public void setResets(String resets) {
        this.resets = resets;
    }
}
