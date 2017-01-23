package com.example.user.assist.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 23.01.2017.
 */

public class Auth {
    @SerializedName("login")
    String login;
    @SerializedName("password")
    String password;

}
