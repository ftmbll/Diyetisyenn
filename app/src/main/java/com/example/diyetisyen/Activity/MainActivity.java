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
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new MainViewModel();
        initNearByDoctor();
    }


    private void initNearByDoctor() {
        binding.progressBar2.setVisibility(View.VISIBLE);
        viewModel.loadDoctors().observe(this, new Observer<List<DoctorsModel>>() {
            @Override
            public void onChanged(List<DoctorsModel> doctors) {
                binding.topView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                binding.topView.setAdapter(new NearDoctorsAdapter(doctors));
                binding.progressBar2.setVisibility(View.GONE);
            }
        });
    }
}