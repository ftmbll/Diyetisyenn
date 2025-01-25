package com.example.diyetisyen.Activity;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.diyetisyen.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterPage extends BaseActivity2 {

    EditText mUserName, mEmail, mPassword;
    Button mCreateBtn;
    TextView loginText;
    FirebaseAuth fAuth;
    ProgressBar mProgressBar;

    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mUserName=findViewById(R.id.userName);
        mEmail=findViewById(R.id.email);
        mPassword=findViewById(R.id.password);
        mCreateBtn=findViewById(R.id.createBtn);
        mProgressBar=findViewById(R.id.progressBar);

        fAuth=FirebaseAuth.getInstance();

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mEmail.getText().toString();
                String password=mPassword.getText().toString();
                String userName=mUserName.getText().toString();

                if(TextUtils.isEmpty(userName)){
                    mUserName.setError("Kullanıcı adı giriniz.");
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Şifre giriniz.");
                }
                if(password.length() < 6){
                    mPassword.setError("Şifre 6 karakterden uzun olmalı.");
                }
                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Mailinizi giriniz.");
                }

                mProgressBar.setVisibility(View.VISIBLE);
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterPage.this, "User Create", Toast.LENGTH_SHORT).show();
                            startActivitySecond();

                            //send verification code
                            FirebaseUser fuser = fAuth.getCurrentUser();
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(RegisterPage.this, "Doğrulama maili gönderildi.", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"onFailure: Email gönderilmedi" + e.getMessage());
                                }
                            });
                        }else {
                            Toast.makeText(RegisterPage.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            mProgressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        loginText = findViewById(R.id.loginText);
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterPage.this, login_page.class);
                startActivity(intent);
            }
        });
    }

    private void startActivitySecond(){
        Intent intent = new Intent(RegisterPage.this, login_page.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}