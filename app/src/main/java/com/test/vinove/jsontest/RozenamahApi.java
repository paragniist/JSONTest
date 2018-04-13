package com.test.vinove.jsontest;

import com.google.gson.JsonElement;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface RozenamahApi {

    @GET("speciality-list")
// sub url
    Call<JsonElement> specialityListApi(@Query("doctor_id") String doctorId,
                                        @Query("lang") String language,
                                        @Query("mob") String mob);

    @POST("login")
    Call<JsonElement> loginApi(@Body JSONObject jsonObject);
}
