package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private EditText et_email, et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("diemo");

        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        Button btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(view -> {
            String strEmail = String.valueOf(et_email.getText());
            String strPass = String.valueOf(et_pass.getText());

            mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPass).addOnCompleteListener(RegisterActivity.this, task -> {
                if (task.isSuccessful()) {
                    FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                    UserAccount account = new UserAccount();
                    account.setIdToken(firebaseUser.getUid());
                    account.setEmail(firebaseUser.getEmail());
                    account.setPassword(strPass);

                    mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);
                    Toast.makeText(RegisterActivity.this, "회원가입에 성공했습니다", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(RegisterActivity.this, "회원가입에 실패했습니다", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}