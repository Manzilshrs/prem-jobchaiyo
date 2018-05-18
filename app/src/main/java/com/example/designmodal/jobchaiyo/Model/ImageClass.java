package com.example.designmodal.jobchaiyo.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Manjil on 5/17/2018.
 */

public class ImageClass
{
    @SerializedName("title")
    private String Title;

    @SerializedName("image")
    private String Image;

    @SerializedName("response")
    private String Response;

    public String getResponse() {
        return Response;
    }
}
