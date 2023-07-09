package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import android.widget.TextView;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;



public class DiaryFragment extends Fragment {
    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_diary, container, false);
        // Inflate the layout for this fragment

        return view;
    }
    }