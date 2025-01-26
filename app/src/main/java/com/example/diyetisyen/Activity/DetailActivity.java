package com.example.diyetisyen.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diyetisyen.Model.DoctorsModel;
import com.example.diyetisyen.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;
    private DoctorsModel item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Bağlama işlemi yapılır.
        // XML'deki görselleri Java nesnelerine bağlamaya olanak tanır
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // activity'nin arayüzünü tanımlar ve kullanıcıya gösterir.

        getBundle();

    }

    private void getBundle(){ //veri alımı
        DoctorsModel item = getIntent().getParcelableExtra("object");  //Intent, bir Activity'den diğerine veri taşımak için kullanılır

        if (item != null){
            binding.specialTxt.setText(item.getSpecial());
            binding.danisanTxt.setText(item.getPatients());
            binding.bioTxt.setText(item.getBiography());
            binding.addressTxt.setText(item.getAddress());
            binding.clockTxt.setText(item.getTime());
            binding.dateTxt.setText(item.getDate());
            binding.deneyimTxt.setText(item.getExperience() + " Years");
            binding.PuanlamaTxt.setText(String.valueOf(item.getRating()));

            // Geri butonu işlemi, detail sayfası kapatılır
            binding.backButton.setOnClickListener(v -> finish());

            // Web sitesine gitme işlemi
            binding.websiteButon.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(item.getSite()));
                startActivity(intent);
            });

            // Mesaj gönderme işlemi (sms)
            binding.mesajButon.setOnClickListener(view ->{
                Uri uri = Uri.parse("smsto:" + item.getMobile());
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "the SMS text");
                startActivity(intent);
            });

            // Telefon araması işlemi
            binding.tefefonButon.setOnClickListener(view -> {
                String uri = "tel:" + item.getMobile().trim();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(uri)); //doktor numarasını oto olarak arama kısmına girer
                startActivity(intent);
            });

            // Resmin yüklenmesi
            Glide.with(this)
                    .load(item.getPicture()) //resmin dosya yolunu döndürür
                    .into(binding.img); //yüklenen image in hangi imageview'a yükleneceğini belirtir
        }
    }

}