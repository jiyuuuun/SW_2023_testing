package com.example.myapplication;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class SettingFragment extends Fragment {
    private FirebaseAuth mFirebaseAuth;
    private View view;
    private Switch mode_switch;
    private TextView modeStatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_setting, container, false);
        //로그아웃
        mFirebaseAuth = FirebaseAuth.getInstance();
        Button btn_logout = view.findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(v -> {
            mFirebaseAuth.signOut();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });
        //탈퇴처리
        Button btn_leave = view.findViewById(R.id.btn_leave);
        btn_leave.setOnClickListener(view1 -> {
            mFirebaseAuth.getCurrentUser().delete();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });
        //다크모드
        mode_switch = view.findViewById(R.id.mode_switch);
        modeStatus = view.findViewById(R.id.tv_mode);

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            modeStatus.setText("Dark Mode");
        } else if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_UNSPECIFIED){
            modeStatus.setText("UnSpecified Mode");
        }else {
            modeStatus.setText("Light Mode");
        }

        mode_switch.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}
=======
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SettingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }
}
>>>>>>> origin/main
