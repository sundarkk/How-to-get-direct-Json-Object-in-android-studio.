package com.sundar.ezetapandroidassignmen.interfaces;


import com.google.gson.JsonObject;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by sundar on 03/09/21.
 */

public interface ApiInterface {


    @FormUrlEncoded
    @POST("android_assignment.json")
    Call<JsonObject> getHome(@Field("page_count") int page_count);


}
