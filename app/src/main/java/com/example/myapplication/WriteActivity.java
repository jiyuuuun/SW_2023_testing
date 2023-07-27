package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;


public class WriteActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference mDatabaseRef;
    private RadioGroup radioGroup;
    private TextView selection;
    private EditText et_content;
    private Button btn_write;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        database = FirebaseDatabase.getInstance();
        mDatabaseRef = database.getReference("diemo").child("write");
        radioGroup = findViewById(R.id.radio_group);
        selection = findViewById(R.id.selection);
        et_content = findViewById(R.id.et_content);
        btn_write = findViewById(R.id.btn_write);
        radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (i) {
                case R.id.radio_happy:
                    selection.setText("행복");
                    break;
                case R.id.radio_sad:
                    selection.setText("슬픔");
                    break;
            }
        });
        btn_write.setOnClickListener(view -> {
            long mNow = System.currentTimeMillis();
            Date mDate = new Date(mNow);
            SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");
            String sDate = mFormat.format(mDate);
            String strContent = et_content.getText().toString();
            String sKey = mDatabaseRef.push().getKey();
            if (sKey != null) {
                mDatabaseRef.child(sKey).child("content").setValue(strContent);
                mDatabaseRef.child(sKey).child("date").setValue(sDate);
                Toast.makeText(WriteActivity.this, "저장 성공", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(WriteActivity.this, DiaryFragment.class);
                startActivity(intent);
            } else {
                Toast.makeText(WriteActivity.this, "저장 실패", Toast.LENGTH_SHORT).show();
            }
        });
    }
}