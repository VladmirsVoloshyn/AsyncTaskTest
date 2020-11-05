package com.example.assynctaskretrofittry2;

import com.example.assynctaskretrofittry2.data.Main;

public interface RequestCallback {
    void onResponse(Main data);
    void onFailure();
}
