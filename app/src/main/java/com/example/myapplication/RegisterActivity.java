package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private EditText et_email, et_pass, et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("diemo");
        findViewById(R.id.btn_register).setOnClickListener(this);
    }
    public void onClick(View v) {
        String strEmail = et_email.getText().toString();
        String strPass = et_pass.getText().toString();
        String strName = et_name.getText().toString();

        mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPass).addOnCompleteListener(RegisterActivity.this, task -> {
            if (task.isSuccessful()) {
                FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                UserAccount account = new UserAccount();
                account.setIdToken(firebaseUser.getUid());
                account.setEmailId(firebaseUser.getEmail());
                account.setNickname(strName);
                account.setPassword(strPass);

                mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);
                Toast.makeText(RegisterActivity.this, "회원가입에 성공하셨습니다",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            } else {
                Toast.makeText(RegisterActivity.this, "회원가입에 실패하셨습니다",Toast.LENGTH_SHORT).show();
            }
        });
    }
}