package com.example.user.assist;

import com.example.user.assist.model.LoginReq;
import com.example.user.assist.model.LoginResponse;
import com.example.user.assist.model.ThemeResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by user on 25.01.2017.
 */

public interface AssistApi {
    @POST("/auth")
    Call<LoginResponse> auth(@Body LoginReq loginReq);

    @GET("/themes")
    Call<ThemeResponse> themes (@Query("token") String token);


}
