package com.example.diyetisyen.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.diyetisyen.R;
import com.example.diyetisyen.databinding.ActivitySplashBinding;


public class SplashActivity extends BaseActivity2 {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this); //Uygulamanın ekranın kenarlarına kadar uzanmasını sağlar
        setContentView(R.layout.activity_splash); //activity_splash.xml dosyasını kullanıcı arayüzü olarak ayarlar.

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.getStartedButton.setOnClickListener(v -> { //"Get Started" düğmesine tıklandığında login page e gidilir
            Intent intent = new Intent(SplashActivity.this, login_page.class);
            startActivity(intent);
        });
    }
}