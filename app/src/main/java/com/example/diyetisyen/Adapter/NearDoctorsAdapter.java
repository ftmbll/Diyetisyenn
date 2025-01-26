package com.example.diyetisyen.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diyetisyen.Model.DoctorsModel;
import com.example.diyetisyen.databinding.ViewholderNearbyDoctorBinding;

import java.util.List;

public class NearDoctorsAdapter extends RecyclerView.Adapter<NearDoctorsAdapter.ViewHolder> { //doktorları listelemek için kullanılan bir RecyclerView.Adapter sınıfı oluşturduk.

    private List<DoctorsModel> items;
    private Context context;

    public NearDoctorsAdapter(List<DoctorsModel> items) {
        this.items = items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ViewholderNearbyDoctorBinding binding;

        public ViewHolder(ViewholderNearbyDoctorBinding binding) { //ViewHolder, her bir liste elemanının görüntüsünü tutar
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewholderNearbyDoctorBinding binding = ViewholderNearbyDoctorBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { //items listesinden doktor bilgilerini alır ve ilgili TextView bileşenlerine atar
        DoctorsModel doctor = items.get(position);
        holder.binding.nameTxt.setText(doctor.getName());
        holder.binding.specialTxt.setText(doctor.getSpecial());
        holder.binding.costTxt.setText(doctor.getCost());

        Glide.with(context)
                .load(doctor.getPicture())
                .apply(new RequestOptions().centerCrop())
                .into(holder.binding.img);
    }

    @Override
    public int getItemCount() { //adaptörün kaç öğe içerdiğini döndürür
        return items.size(); //items listesinin boyutunu döndürür
    }
}
