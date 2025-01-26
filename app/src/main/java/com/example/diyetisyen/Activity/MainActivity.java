package com.example.diyetisyen.Activity;
import android.view.View;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.diyetisyen.Activity.BaseActivity2;
import com.example.diyetisyen.Adapter.NearDoctorsAdapter;
import com.example.diyetisyen.Model.DoctorsModel;
import com.example.diyetisyen.ViewModel.MainViewModel;
import com.example.diyetisyen.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends BaseActivity2 {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); //xml dosyasındaki görseller java nesnesine bağlanır
        setContentView(binding.getRoot()); //ana görünüm tanımlanır

        viewModel = new MainViewModel(); //doktor verilerinin yükleneceği bir ViewModel olarak tanımlanır
        initNearByDoctor(); //doktor listesi çekilir
    }


    private void initNearByDoctor() {
        binding.progressBar2.setVisibility(View.VISIBLE);
        viewModel.loadDoctors().observe(this, new Observer<List<DoctorsModel>>() { //MainViewModel sınıfındaki loadDoctors() metodu çağrılır ve bir LiveData<List<DoctorsModel>> döndürür.
                                                                                        //LiveData nesnesi, gözlemlenir ve her değişiklikte bir Observer tetiklenir
            @Override
            public void onChanged(List<DoctorsModel> doctors) {
                if (doctors == null || doctors.isEmpty()) {
                    //Eğer liste boşsa veya yüklenememişse kullanıcıya bir mesaj gösterilir
                    binding.emptyView.setVisibility(View.VISIBLE); //boş mesaj görünür
                    binding.topView.setVisibility(View.GONE); //liste gizlenir
                } else {
                    //eğer veri varsa listeyi yükler
                    binding.emptyView.setVisibility(View.GONE); //boş mesaj gizlenir
                    binding.topView.setVisibility(View.VISIBLE); //liste görünür

                    binding.topView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false)); //liste dikey olarak sıralanır
                    binding.topView.setAdapter(new NearDoctorsAdapter(doctors)); //doktor listesi adaptera bağlanır, her bir doktor için liste öğelerini oluşturur ve bağlar
                }
                binding.progressBar2.setVisibility(View.GONE); //yüklenme işlemi tamamlandığında progressBar gizlenir
            }
        });
    }
}