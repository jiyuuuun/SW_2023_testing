package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class DiaryFragment extends Fragment {
    private View view;
    private FloatingActionButton btn_floating;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_diary, container, false);
        // Inflate the layout for this fragment

        btn_floating = view.findViewById(R.id.btn_floating);
        btn_floating.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), WriteActivity.class);
            startActivity(intent);
        });

        return view;
    }
    }