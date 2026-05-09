package com.example.mdjb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mdjb.R;

import java.util.List;
public class HistoryAdapter extends ArrayAdapter<String[]>{
    public HistoryAdapter(Context context, List<String[]>records){
        super(context, 0, records);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String[]data = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_historique, parent, false);
        }
        TextView txtDate = convertView.findViewById(R.id.txt_item_date);
        ImageView imgMood = convertView.findViewById(R.id.img_item_mood);
        TextView txtNote = convertView.findViewById(R.id.txt_item_note);
        //remplissage avec index du tableau
        txtDate.setText(data[0]);
        txtNote.setText(data[2]);
        //changement de l'image selon le score
        if (data[1].equals("3")) imgMood.setImageResource(R.drawable.happy);
        else if (data[1].equals("1")) imgMood.setImageResource(R.drawable.sad);
        else imgMood.setImageResource(R.drawable.neutral);

        return convertView;
    }
}
