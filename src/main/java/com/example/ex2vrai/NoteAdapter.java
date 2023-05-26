package com.example.ex2vrai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(@NonNull Context context, @NonNull List<Note> objects) {
        super(context,0,  objects);
    }
    @NonNull
    @Override
    public View getView(int position , @Nullable View convertView, @NonNull ViewGroup parent){
        View newItem;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        newItem=li.inflate(R.layout.note_line,parent,false);
        ImageView icon=newItem.findViewById(R.id.iconLike);
        TextView txtMatiere=newItem.findViewById(R.id.txtMatiere);
        TextView txtScore=newItem.findViewById(R.id.txtScore);
        if(this.getItem(position).getScore()<10)
            icon.setImageResource(R.drawable.ic_dislike);
        else
            icon.setImageResource(R.drawable.ic_like);
        txtMatiere.setText(this.getItem(position).getLebel());
        txtScore.setText(this.getItem(position).getScore()+"");

        return newItem;
    }
}
