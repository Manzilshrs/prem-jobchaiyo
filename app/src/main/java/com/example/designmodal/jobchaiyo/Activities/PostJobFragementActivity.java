package com.example.designmodal.jobchaiyo.Activities;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.designmodal.jobchaiyo.Fragments.PostJobLoginFragment;
import com.example.designmodal.jobchaiyo.Fragments.Welcome;
import com.example.designmodal.jobchaiyo.R;

public class PostJobFragementActivity extends AppCompatActivity {

    PostJobLoginFragment postJobLoginFragment;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job_fragement);
        postJobLoginFragment=new PostJobLoginFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PostJobLoginFragment()).commit();



    }
}