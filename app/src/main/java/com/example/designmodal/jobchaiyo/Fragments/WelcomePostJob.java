package com.example.designmodal.jobchaiyo.Fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.designmodal.jobchaiyo.Activities.MainActivity;
import com.example.designmodal.jobchaiyo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomePostJob extends Fragment {
    TextView textView;
    Button logout;

    OnLogoutListener logoutListener;
public interface OnLogoutListener
{
    public void logoutperform();
}

    public WelcomePostJob() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome_post_job, container, false);

        textView=view.findViewById(R.id.name);
        textView.setText("Welcome "+MainActivity.prefConfig.readName());
        logout=view.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutListener.logoutperform();

            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity=(Activity) context;
        logoutListener=(OnLogoutListener) activity;
    }
}
