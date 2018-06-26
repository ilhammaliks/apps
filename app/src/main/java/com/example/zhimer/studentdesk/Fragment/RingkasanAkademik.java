package com.example.zhimer.studentdesk.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhimer.studentdesk.R;

public class RingkasanAkademik extends Fragment {

    public RingkasanAkademik() {
        // Required empty public constructor
        String title = "Ringkasan Akademik";
    }


    private FragmentTabHost tabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.nav_ringkasan_akademik, container, false);
    }
}
