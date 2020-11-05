package com.example.assynctaskretrofittry2;

import com.example.assynctaskretrofittry2.data.Main;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface HolidaysPlaceHolderAPI {

    @GET("holidays?pretty")
    Call <Main> getListHolidays(@Query("key") String ker,
                                @Query("country") String country,
                                @Query("year") String year);
}
