package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private HomeFragment homeFragment;
    private DiaryFragment diaryFragment;
    private BulletinFragment bulletinFragment;
    private SettingFragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navi);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    setFrag(0);
                    break;
                case R.id.diary:
                    setFrag(1);
                    break;
                case R.id.bulletin:
                    setFrag(2);
                    break;
                case R.id.setting:
                    setFrag(3);
                    break;
            }
            return true;
        });
        homeFragment = new HomeFragment();
        diaryFragment = new DiaryFragment();
        bulletinFragment = new BulletinFragment();
        settingFragment = new SettingFragment();
        setFrag(0);
    }
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.containers, homeFragment);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.containers, diaryFragment);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.containers, bulletinFragment);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.containers, settingFragment);
                ft.commit();
                break;
        }
    }
}