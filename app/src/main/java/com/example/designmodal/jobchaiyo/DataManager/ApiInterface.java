package com.example.designmodal.jobchaiyo.DataManager;

import com.example.designmodal.jobchaiyo.Model.ImageClass;
import com.example.designmodal.jobchaiyo.Model.ListofJobCategory;
import com.example.designmodal.jobchaiyo.Model.ListofJobOwnership;
import com.example.designmodal.jobchaiyo.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Manjil on 5/13/2018.
 */

public interface ApiInterface {
    @POST("register.php")
    @FormUrlEncoded
    Call<User> performRegistration(@Field("name") String Name, @Field("address") String Address,
                                   @Field("website") String Website, @Field("person") String Person,
                                   @Field("office") String Office, @Field("mobile") String Mobile,
                                   @Field("email") String Email, @Field("optemail") String Optemail,
                                   @Field("username") String Username, @Field("password") String Password,
                                   @Field("category") Integer JobCategoy, @Field("ownership") Integer JobOwnership);


                                 //  @Field("title") String Title, @Field("image") String Image);
    @POST("upload.php")
    @FormUrlEncoded
    Call<ImageClass> uploadImage(@Field("title") String title, @Field("image") String image);


    @POST("login.php")
    @FormUrlEncoded
    Call<User> performUserLogin(@Field("email") String Email,@Field("password") String Password);

    @GET("job_ownership_list.php")
    Call<List<ListofJobOwnership>> getJobOwnershipList();

    @GET("job_category_list.php")
     Call<List<ListofJobCategory>> getJobCategoryList();
}
