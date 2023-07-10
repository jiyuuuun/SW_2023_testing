package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private final FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private final FirebaseFirestore mStore = FirebaseFirestore.getInstance();
    private EditText et_email, et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        findViewById(R.id.btn_register).setOnClickListener(this);
    }
    public void onClick(View v) {
        mAuth.createUserWithEmailAndPassword(et_email.getText().toString(), et_pass.getText().toString())
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            Map<String, Object> userMap = new HashMap<>();
                            userMap.put(UserAccount.documentId, user.getUid());
                            userMap.put(UserAccount.email, et_email.getText().toString());
                            userMap.put(UserAccount.password, et_pass.getText().toString());
                            mStore.collection(UserAccount.user).document(user.getUid()).set(userMap, SetOptions.merge());
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            Toast.makeText(RegisterActivity.this, "회원 등록에 성공했습니다", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "회원 등록에 실패했습니다", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}