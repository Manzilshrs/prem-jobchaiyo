package com.example.designmodal.jobchaiyo.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.designmodal.jobchaiyo.R;

/**
 * Created by Manjil on 5/17/2018.
 */

public class tab_jobs_posted_frag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_jobs_posted,container,false);
    }
}
