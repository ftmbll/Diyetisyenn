package com.example.diyetisyen.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.diyetisyen.Repository.MainRepository;
import com.example.diyetisyen.Model.DoctorsModel;

import java.util.List;

public class MainViewModel extends ViewModel {
    private final MainRepository repository = new MainRepository();

    public LiveData<List<DoctorsModel>> loadDoctors() {
        return repository.load();
    }
}
