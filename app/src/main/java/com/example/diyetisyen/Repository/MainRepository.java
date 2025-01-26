package com.example.diyetisyen.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.diyetisyen.Model.DoctorsModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainRepository {

    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    public LiveData<List<DoctorsModel>> load() {
        MutableLiveData<List<DoctorsModel>> listData = new MutableLiveData<>(); //mutablelivedata bir veri tutucu sınıfıdır. verileri güncelleme özelliğine sahip
        DatabaseReference ref = firebaseDatabase.getReference("Doctors");

        ref.addValueEventListener(new ValueEventListener() { //firebaseden verileri çekmek için kullanılan listener türü
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<DoctorsModel> lists = new ArrayList<>();
                for (DataSnapshot childSnapshot : snapshot.getChildren()) { //verileri listeye ekler
                    DoctorsModel item = childSnapshot.getValue(DoctorsModel.class); //verileri DoctorsModel sınıfına dönüştürür
                    if (item != null) {
                        lists.add(item); //listeye ekler
                    }
                }
                listData.setValue(lists);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // İsteğe bağlı: Bir hata mesajı göstermek için bu alanı düzenleyebilirsiniz.
                throw new RuntimeException("Error: " + error.getMessage());
            }
        });
        return listData;

    }
}
