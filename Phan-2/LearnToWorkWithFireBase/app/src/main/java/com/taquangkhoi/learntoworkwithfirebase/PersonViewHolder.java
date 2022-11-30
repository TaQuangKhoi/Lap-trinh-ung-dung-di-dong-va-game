package com.taquangkhoi.learntoworkwithfirebase;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class PersonViewHolder extends RecyclerView.ViewHolder {
    public TextView tvwName, tvwAge, tvwOption;
    public PersonViewHolder(@NotNull View itemView) {
        super(itemView);
        tvwName = itemView.findViewById(R.id.tvwName);
        tvwAge = itemView.findViewById(R.id.tvwAge);
        tvwOption = itemView.findViewById(R.id.tvwOption);
    }
}
