package com.example.designmodal.jobchaiyo.DataManager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Manjil on 5/13/2018.
 */

public class ApiClient {

    public static final String BASE_URL = "http://192.168.1.84/JobchaheyoAPI/";
    public  static Retrofit retrofit= null;

    public  static Retrofit getApiClient()
    {
        if (retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }
}
