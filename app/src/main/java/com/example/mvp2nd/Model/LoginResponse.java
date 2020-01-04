package com.example.mvp2nd.Model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public DataDetail data;
}
