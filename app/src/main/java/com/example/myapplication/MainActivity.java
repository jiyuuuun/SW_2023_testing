package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;

    HomeFragment homeFragment;
    DiaryFragment diaryFragment;
    BulletinFragment bulletinFragment;
    SettingFragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        Button btn_logout = findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(v -> {
            mFirebaseAuth.signOut();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
        //탈퇴처리
        //mFirebaseAuth.getCurrentUser().delete();

        homeFragment = new HomeFragment();
        diaryFragment = new DiaryFragment();
        bulletinFragment = new BulletinFragment();
        settingFragment = new SettingFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();

        NavigationBarView navigationBarView = findViewById(R.id.bottom_navigationview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();
                        return true;
                    case R.id.diary:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, diaryFragment).commit();
                        return true;
                    case R.id.bulletin:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, bulletinFragment).commit();
                        return true;
                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, settingFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
}