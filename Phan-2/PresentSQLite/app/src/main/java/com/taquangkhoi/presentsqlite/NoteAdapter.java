package com.taquangkhoi.presentsqlite;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NoteAdapter extends ArrayAdapter<Note> {
    private Context context; // Trà về Activity mà ListView hiển thị - this
    private int resource;

    public NoteAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customView = View.inflate(context, resource, null);

        // Ánh xạ thông qua customView
        TextView tvwTitle = customView.findViewById(R.id.tvw_Title);
        TextView tvwContent = customView.findViewById(R.id.tvw_Content);

        Note note = getItem(position); // Lấy đối tượng

        // Gán dữ liệu từ Database vào View
        tvwTitle.setText(note.getTitle());
        tvwContent.setText(note.getContent());

        return customView;
    }
}
