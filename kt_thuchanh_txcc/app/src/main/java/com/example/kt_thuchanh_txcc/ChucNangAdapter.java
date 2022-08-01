package com.example.kt_thuchanh_txcc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ChucNangAdapter extends ArrayAdapter<ChucNang> {
    Context context;
    int resource;

    public ChucNangAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customView = LayoutInflater.from(context).inflate(resource, null);
        // LayoutInflater dùng để biến file xml thành một View nè..

        ImageView ivIcon = customView.findViewById(R.id.iv_icon);
        TextView tvChucNang = customView.findViewById(R.id.tv_chucnang);
        LinearLayout gvChucNang = customView.findViewById(R.id.ll_chucnang);

        ChucNang chucNang = getItem(position);

        ivIcon.setImageResource(chucNang.getImIconID());
        tvChucNang.setText(chucNang.getTenChucNang());
        gvChucNang.setBackgroundColor(chucNang.getBackgroundColor());


        return customView;
    }
}
