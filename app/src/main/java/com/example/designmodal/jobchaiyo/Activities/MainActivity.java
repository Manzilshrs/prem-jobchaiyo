package com.example.designmodal.jobchaiyo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.designmodal.jobchaiyo.Fragments.LoginPostJob;
import com.example.designmodal.jobchaiyo.Fragments.RegisterPostJob;
import com.example.designmodal.jobchaiyo.Fragments.WelcomePostJob;
import com.example.designmodal.jobchaiyo.R;
import com.example.designmodal.jobchaiyo.sharePref.PrefConfig;

public class MainActivity extends AppCompatActivity implements LoginPostJob.OnLoginFormActivityListener{
public static PrefConfig prefConfig;
   // public static ApiInterface apiInterface;
    //yesma implement garnu pardai
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefConfig= new PrefConfig(this);
       // apiInterface= ApiClient.getApiClient().create(ApiInterface.class);

        if (findViewById(R.id.fragment_container)!=null)
        {
            if (savedInstanceState!=null)
            {
                return;
            }

            if (prefConfig.readLoginStatus())
            {
                //user already login
               // getFragmentManager().beginTransaction().add(R.id.fragment_container,new WelcomePostJob()).commit();
                Intent intent=new Intent(MainActivity.this,Main2ActivityTab.class);
                startActivity(intent);
                finish();
            }
            else
            {
                getFragmentManager().beginTransaction().add(R.id.fragment_container,new LoginPostJob()).commit();

                //display login page
            }
        }
    }

    @Override
    public void performRegister() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container,new RegisterPostJob())
                .addToBackStack(null).commit();
    }

    @Override
    public void performLogin(String name)
    {
        prefConfig.writeNmae(name);
        //getFragmentManager().beginTransaction().replace(R.id.fragment_container,new WelcomePostJob()).commit();

        Intent intent=new Intent(MainActivity.this,Main2ActivityTab.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
//    @Override
//    public void logoutperform() {
//        prefConfig.writeLoginStatus(false);
//        prefConfig.writeNmae("User");
//        getFragmentManager().beginTransaction().replace(R.id.fragment_container,new LoginPostJob()).commit();
//
//    }
}
