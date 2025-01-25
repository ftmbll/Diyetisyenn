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

                if (TextUtils.isEmpty(usernameInput)) {
                    Toast.makeText(login_page.this, "Please enter your full name", Toast.LENGTH_LONG).show();
                    UsernameText.setError("Full Name is Required");
                    UsernameText.requestFocus();
                } else if (TextUtils.isEmpty(passwordInput)) {
                    Toast.makeText(login_page.this, "Please enter your password", Toast.LENGTH_LONG).show();
                    PasswordText.setError("Full Name is Required");
                    PasswordText.requestFocus();
                }

                Intent intent = new Intent(login_page.this, MainActivity.class);
                startActivity(intent);

            }

        });

        Button createAccountBtn = findViewById(R.id.createAccountBtn);
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(login_page.this, RegisterPage.class);
                startActivity(intent);

            }
        });

        ForgotPasswordBtn = findViewById(R.id.ForgotPasswordBtn);
        ForgotPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_page.this, ResetpasswordActivity.class);
                startActivity(intent);
            }
        });

    }
}