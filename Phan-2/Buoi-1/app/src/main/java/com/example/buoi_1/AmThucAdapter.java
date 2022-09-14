package com.example.buoi_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AmThucAdapter extends ArrayAdapter<AmThuc> {
    // khai báo thuộc tính để có thể truy cập mọi nơi trong class
    private Context context; // Trà về Activity mà ListView hiển thị - this
    private int resource;

    public AmThucAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customView = LayoutInflater.from(context).inflate(resource, null);

        // Ánh xạ thông qua customView (chưa có data)
        ImageView imageView = customView.findViewById(R.id.imageView);
        TextView tvName = customView.findViewById(R.id.textView);

        // Lấy dữ liệu từ phần tử với position trong mảng đưa vào từng View
        imageView.setImageResource(getItem(position).getIdImage());
        tvName.setText(getItem(position).getNameAmThuc());

        return customView;
    }
}
