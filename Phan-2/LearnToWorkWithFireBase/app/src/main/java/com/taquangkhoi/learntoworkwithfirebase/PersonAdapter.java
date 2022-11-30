package com.taquangkhoi.learntoworkwithfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Person> arrayList = new ArrayList<>();

    public PersonAdapter(Context context) {
        this.context = context;
    }

    public void setItems(ArrayList<Person> persons){
        arrayList.addAll(persons);
    }

    public void clearItems(){
        arrayList.clear();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_recyclerview, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PersonViewHolder userVH = (PersonViewHolder) holder;
        Person user = arrayList.get(position);
        userVH.tvwName.setText(user.getName());
        userVH.tvwAge.setText(user.getAge());
        userVH.tvwOption.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(context, userVH.tvwOption);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.menu_update:
                        EditText edtTextName, edtTextAge;
                        LayoutInflater inflater = LayoutInflater.from(context);
                        final View textEntryView = inflater.inflate(R.layout.custom_alert_dialog, null);
                        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                        alertBuilder.setTitle("Update user" + userVH.tvwName.getText().toString());
                        alertBuilder.setMessage("Enter new information");
                        alertBuilder.setView(textEntryView);

                        edtTextName = textEntryView.findViewById(R.id.editTextName);
                        edtTextAge = textEntryView.findViewById(R.id.editTextAge);

                        break;
                    case R.id.menu_delete:

                        break;
                }
                return false;
            });
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
