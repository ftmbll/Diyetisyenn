package com.example.diyetisyen.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.diyetisyen.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login_page extends AppCompatActivity {

    private EditText UsernameText, PasswordText;
    TextView ForgotPasswordBtn;
    private FirebaseAuth mAuth;
    private Button loginButton, createAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        UsernameText = findViewById(R.id.UsernameText);
        PasswordText = findViewById(R.id.PasswordText);
        mAuth = FirebaseAuth.getInstance();
        loginButton = findViewById(R.id.loginButton);
        createAccountBtn = findViewById(R.id.createAccountBtn);
        ForgotPasswordBtn = findViewById(R.id.ForgotPasswordBtn);

        // Giriş Yap Butonu
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        // Kayıt Ol Butonu
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_page.this, RegisterPage.class);
                startActivity(intent);
            }
        });

        // Şifremi Unuttum Butonu
        ForgotPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_page.this, ResetpasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser() {
        String usernameInput = UsernameText.getText().toString().trim();
        String passwordInput = PasswordText.getText().toString().trim();

        if (TextUtils.isEmpty(usernameInput)) {
            Toast.makeText(login_page.this, "Lütfen kullanıcı adınızı giriniz", Toast.LENGTH_LONG).show();
            UsernameText.setError("Kullanıcı Adı Girmek Zorunlu");
            UsernameText.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(passwordInput)) {
            Toast.makeText(login_page.this, "Lütfen şifrenizi giriniz", Toast.LENGTH_LONG).show();
            PasswordText.setError("Şifre Girmek Zorunlu");
            PasswordText.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(usernameInput, passwordInput)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("TAG", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            if (user != null) {
                                if (user.isEmailVerified()) {
                                    Toast.makeText(login_page.this, "Giriş Başarılı", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(login_page.this, MainActivity.class);
                                    startActivity(intent);
                                    finish(); // Giriş başarılıysa login sayfasını kapat
                                } else {
                                    Toast.makeText(login_page.this, "Lütfen e-posta adresinizi doğrulayın.", Toast.LENGTH_LONG).show();
                                    mAuth.signOut(); // Doğrulanmamış kullanıcıyı oturumdan çıkar
                                }
                            }
                        } else {
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(login_page.this, "Giriş Başarısız: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}