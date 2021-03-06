package com.example.designmodal.jobchaiyo.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.designmodal.jobchaiyo.Activities.Main2ActivityTab;
import com.example.designmodal.jobchaiyo.Activities.MainActivity;
import com.example.designmodal.jobchaiyo.R;

/**
 * Created by Manjil on 5/17/2018.
 */

public class tab_profile_frag extends Fragment {

   // Button logout;
    TextView address,name,website,contactPerson,officeContact,mobile,email,optEmail,username,password;
    Button logout;

    OnLogoutListener logoutListener;
    public interface OnLogoutListener
    {
        public void logoutperform();
    }

    //public WelcomePostJob() {
        // Required empty public constructor
    //}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_profile, container, false);

        //    textView=view.findViewById(R.id.name);
        //  textView.setText("Welcome "+ MainActivity.prefConfig.readName());
        logout = view.findViewById(R.id.logout);


        name = view.findViewById(R.id.name);
        address = view.findViewById(R.id.address);
        website = view.findViewById(R.id.website);
        contactPerson = view.findViewById(R.id.contactPerson);
        officeContact = view.findViewById(R.id.officeContact);
        mobile = view.findViewById(R.id.mobile);
        email = view.findViewById(R.id.email);
        optEmail = view.findViewById(R.id.optEmail);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);

        name.setText(MainActivity.prefConfig.readCompanyName());
        address.setText(MainActivity.prefConfig.readAddress());
        website.setText(MainActivity.prefConfig.readWebsite());
        contactPerson.setText(MainActivity.prefConfig.readPerson());
        officeContact.setText(MainActivity.prefConfig.readOffice());
        mobile.setText(MainActivity.prefConfig.readMobile());
        email.setText( MainActivity.prefConfig.readEmail());
        optEmail.setText(MainActivity.prefConfig.readOptEmail());
        username.setText(MainActivity.prefConfig.readUsername());
        password.setText(MainActivity.prefConfig.readPassword());
//        Toast.makeText(getContext(), "id" + MainActivity.prefConfig.readid(), Toast.LENGTH_SHORT).show();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Are you Sure,Logout?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        logoutListener.logoutperform();
                    }
                }).setNegativeButton("Cancel", null);

                AlertDialog alert = builder.create();
                alert.show();


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
