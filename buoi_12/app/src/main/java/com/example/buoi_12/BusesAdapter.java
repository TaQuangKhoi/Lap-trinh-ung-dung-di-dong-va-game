package com.example.buoi_12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BusesAdapter extends ArrayAdapter<Buses> {

    // khai báo thuộc tính để có thể truy cập mọi nơi trong class
    private Context context;
    private int resource;

    // Viết lại Constructor
    // Là method cần được ghi đè khi kế thừa ArrayAdapter
    public BusesAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customView = LayoutInflater.from(context).inflate(resource, null);

        // Ánh xạ
        ImageView imageView = customView.findViewById(R.id.ivBus);
        TextView tvNameBus = customView.findViewById(R.id.tvNameBus);
        TextView tvRouteBus = customView.findViewById(R.id.tvRouteBus);

        // Lấy dữ liệu từ từng phần tử trong mảng
        Buses bus = getItem(position);
        imageView.setImageResource(getItem(position).getIdImage());
        tvNameBus.setText(getItem(position).getNameBus());
        tvRouteBus.setText(getItem(position).getRouteBus());

        return customView;
    }
}

