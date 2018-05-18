package com.example.designmodal.jobchaiyo.Fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.designmodal.jobchaiyo.Activities.Main2ActivityTab;
import com.example.designmodal.jobchaiyo.Activities.MainActivity;
import com.example.designmodal.jobchaiyo.DataManager.ApiClient;
import com.example.designmodal.jobchaiyo.DataManager.ApiInterface;
import com.example.designmodal.jobchaiyo.Model.User;
import com.example.designmodal.jobchaiyo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginPostJob extends Fragment {
    TextView Register;
    EditText Email,Password;
    Button Login;
    private ApiInterface apiInterface;
    OnLoginFormActivityListener loginFormActivityListener;
    //WelcomePostJob.OnLogoutListener logoutListener;
public interface OnLoginFormActivityListener
{
    public void performRegister();
    public void performLogin(String name);
}

    public LoginPostJob() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_login_post_job, container, false);
        Register= view.findViewById(R.id.Register);
        Email=view.findViewById(R.id.Email);
        Password=view.findViewById(R.id.Password);
        Login=view.findViewById(R.id.Login);
        apiInterface=  ApiClient.getApiClient().create(ApiInterface.class);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performLogin();

            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginFormActivityListener.performRegister();

            }
        });


        return view;
    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Activity activity=(Activity) context;
//        loginFormActivityListener=(OnLoginFormActivityListener) activity;
//
//    }

    private void performLogin(){
        String email=Email.getText().toString();
        String password=Password.getText().toString();
        Call<User> call =apiInterface.performUserLogin(email,password);

        call.enqueue(new Callback<User>()
        {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body().getResponse().equals("ok"))
                {
                    MainActivity.prefConfig.writeLoginStatus(true);
                   // loginFormActivityListener.performLogin(response.body().getName());
                    Intent intent=new Intent(getContext(), Main2ActivityTab.class);
                    startActivity(intent);
                }
                else if (response.body().getResponse().equals("failed"))
                {
                    MainActivity.prefConfig.displayToast("Login failed...Please try again...");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        Email.setText("");
        Password.setText("");
    }
}
