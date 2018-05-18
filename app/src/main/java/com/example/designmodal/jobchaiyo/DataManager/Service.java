package com.example.designmodal.jobchaiyo.DataManager;

import android.util.Log;

import com.example.designmodal.jobchaiyo.Model.ListofJobCategory;
import com.example.designmodal.jobchaiyo.Model.ListofJobOwnership;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Manjil on 5/15/2018.
 */




public class Service {

    ApiInterface apiService;
    public Service() {
        apiService = ApiClient.getApiClient().create(ApiInterface.class);
    }


    public interface GetJobCallback{
       void onSuccessJobOwnership(List<ListofJobOwnership> listofJobOwnerhips);
        void onSuccessJobCategory(List<ListofJobCategory> listofJobCategory);
        void onError(String e);
    }


        public void getJobOwnerShipList(final GetJobCallback callback){
        Call<List<ListofJobOwnership>> l = apiService.getJobOwnershipList();
        l.enqueue(new Callback<List<ListofJobOwnership>>(){
            @Override
            public void onResponse(Call<List<ListofJobOwnership>> call, Response<List<ListofJobOwnership>> response) {
                List<ListofJobOwnership> s = response.body();
                if (s!=null && s.size() > 0){
                    callback.onSuccessJobOwnership(s);
                }else{
                    callback.onError("No data available");
                }
            }
            @Override
            public void onFailure(Call<List<ListofJobOwnership>> call, Throwable t) {
                Log.d("dfdfd", "onFailure: " + t.getCause());
            }
        });
    }

    public void getJobCategoryList(final GetJobCallback callback){
        Call<List<ListofJobCategory>> c = apiService.getJobCategoryList();
        c.enqueue(new Callback<List<ListofJobCategory>>(){
            @Override
            public void onResponse(Call<List<ListofJobCategory>> call, Response<List<ListofJobCategory>> response) {
                List<ListofJobCategory> s = response.body();
                if (s!=null && s.size() > 0){
                    callback.onSuccessJobCategory(s);
                }else{
                    callback.onError("No data available");
                }
            }
            @Override
            public void onFailure(Call<List<ListofJobCategory>> call, Throwable t) {
                Log.d("dfdfd", "onFailure: " + t.getCause());
            }
        });
    }



}
