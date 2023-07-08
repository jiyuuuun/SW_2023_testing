package com.example.myapplication;

import android.os.Bundle;
<<<<<<< HEAD
=======

import androidx.fragment.app.Fragment;

>>>>>>> origin/main
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

<<<<<<< HEAD
import androidx.fragment.app.Fragment;

public class BulletinFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bulletin, container, false);
        // Inflate the layout for this fragment
        return view;
    }
}
=======
public class BulletinFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bulletin, container, false);
    }
}
>>>>>>> origin/main
