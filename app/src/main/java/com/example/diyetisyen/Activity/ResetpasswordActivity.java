package com.example.diyetisyen.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.diyetisyen.R;
import com.google.firebase.auth.FirebaseAuth;

public class ResetpasswordActivity extends AppCompatActivity {

    private EditText email_reset;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resetpassword);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Firebase Authentication başlatılıyor
        mAuth = FirebaseAuth.getInstance();


        email_reset = findViewById(R.id.email_reset);
        Button sendLinkBtn = findViewById(R.id.sendLinkBtn);
        sendLinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailReset =  email_reset.getText().toString();

                if (TextUtils.isEmpty(emailReset)){
                    Toast.makeText(ResetpasswordActivity.this, "Please enter your email", Toast.LENGTH_LONG).show();
                    email_reset.setError("Email is Required");
                    email_reset.requestFocus();
                    return;
                }

                // Firebase üzerinden şifre sıfırlama bağlantısı gönderiliyor
                mAuth.sendPasswordResetEmail(emailReset)
                        .addOnCompleteListener(task -> {
                            if(task.isSuccessful()){
                                Toast.makeText(ResetpasswordActivity.this, "Password reset link sent to your email.", Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(ResetpasswordActivity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }
}