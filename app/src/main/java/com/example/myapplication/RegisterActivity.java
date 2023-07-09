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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    private FirebaseFirestore mStore;

    private EditText et_email, et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mStore = FirebaseFirestore.getInstance();

        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        Button btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(view -> {
            String strEmail = String.valueOf(et_email.getText());
            String strPass = String.valueOf(et_pass.getText());

            mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPass).addOnCompleteListener(RegisterActivity.this, task -> {
                if (task.isSuccessful()) {
                    FirebaseUser user = mFirebaseAuth.getCurrentUser();
                    if (user != null) {
                        Map<String, Object> userMap = new HashMap<>();
                        userMap.put(UserAccount.documentId, user.getUid());
                        userMap.put(UserAccount.email, strEmail);
                        userMap.put(UserAccount.password, strPass);
                        mStore.collection(UserAccount.user).document(user.getUid()).set(userMap, SetOptions.merge());
                        finish();
                    }
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