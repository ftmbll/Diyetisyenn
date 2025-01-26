package com.example.diyetisyen.Activity;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.diyetisyen.R;

public class login_page extends BaseActivity2 {

    private EditText UsernameText, PasswordText;
    TextView ForgotPasswordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        UsernameText = findViewById(R.id.UsernameText);
        PasswordText = findViewById(R.id.PasswordText);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usernameInput = UsernameText.getText().toString();
                String passwordInput = PasswordText.getText().toString();

                if (TextUtils.isEmpty(usernameInput)) { // Kullanıcı adı boş mu kontrol edilir
                    Toast.makeText(login_page.this, "Lütfen kullanıcı adınızı giriniz", Toast.LENGTH_LONG).show();
                    UsernameText.setError("Kullanıcı Adı Girmek Zorunlu");
                    UsernameText.requestFocus();
                } else if (TextUtils.isEmpty(passwordInput)) { // Şifre boş mu kontrol edilir
                    Toast.makeText(login_page.this, "Lütfen şifrenizi giriniz", Toast.LENGTH_LONG).show();
                    PasswordText.setError("Şifre Girmek Zorunlu");
                    PasswordText.requestFocus();
                }

                Intent intent = new Intent(login_page.this, MainActivity.class); // Başarılı girişte ana sayfaya yönlendirme
                startActivity(intent);

            }

        });

        Button createAccountBtn = findViewById(R.id.createAccountBtn); // Kayıt ol butonu
        createAccountBtn.setOnClickListener(new View.OnClickListener() { // Kayıt ol butonuna tıklandığında
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(login_page.this, RegisterPage.class); // Kayıt sayfasına yönlendirme
                startActivity(intent);

            }
        });

        ForgotPasswordBtn = findViewById(R.id.ForgotPasswordBtn); // Şifre sıfırlama butonu
        ForgotPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_page.this, ResetpasswordActivity.class); // Şifre sıfırlama sayfasına yönlendirme
                startActivity(intent);
            }
        });

    }
}