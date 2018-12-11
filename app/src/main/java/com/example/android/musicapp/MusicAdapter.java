package com.example.android.musicapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<MusicInfo> {

    public MusicAdapter(@NonNull Context context, ArrayList<MusicInfo> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MusicInfo currentInfo = getItem(position);
        assert currentInfo != null;
        viewHolder.imageView.setImageResource(currentInfo.getImageId());
        viewHolder.genreTv.setText(currentInfo.getGenre());
        viewHolder.descriptionTv.setText(currentInfo.getDescr());
        return convertView;
    }

    class ViewHolder {

        ImageView imageView;
        TextView genreTv;
        TextView descriptionTv;

        ViewHolder(View view) {
            imageView = view.findViewById(R.id.imageArt);
            genreTv = view.findViewById(R.id.genre_tv);
            descriptionTv = view.findViewById(R.id.description_tv);
        }
    }
}
