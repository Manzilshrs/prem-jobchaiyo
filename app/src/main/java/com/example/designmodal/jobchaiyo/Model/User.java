package com.example.designmodal.jobchaiyo.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Manjil on 5/13/2018.
 */

public class User {
    @SerializedName("response")
    private String Response;

    @SerializedName("name")
    private  String Name;

   // @SerializedName("title")
    //private String Title;

    //@SerializedName("image")
//    private String Image;


    public String getResponse() {
        return Response;
    }

    public String getName()
    {
        return Name;
    }
}
