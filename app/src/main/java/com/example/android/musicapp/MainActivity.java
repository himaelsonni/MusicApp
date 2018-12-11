package com.example.android.musicapp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MusicAdapter adapter;
    ArrayList<MusicInfo> arrayList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        arrayList = new ArrayList<>();
        arrayList.add(new MusicInfo(R.drawable.classic_music, "Classic", getString(R.string.classic)));
        arrayList.add(new MusicInfo(R.drawable.country_music, "Country", getString(R.string.country)));
        arrayList.add(new MusicInfo(R.drawable.electronic_music, "Electronic", getString(R.string.electronic)));
        arrayList.add(new MusicInfo(R.drawable.folk_music, "Folk", getString(R.string.folk)));
        arrayList.add(new MusicInfo(R.drawable.french_music, "French", getString(R.string.french)));
        arrayList.add(new MusicInfo(R.drawable.hip_hop_music, "Hip-Hop", getString(R.string.hip_hop)));
        adapter = new MusicAdapter(this, arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                MusicInfo musicInfo = (MusicInfo) adapterView.getItemAtPosition(position);
                int artId = musicInfo.getImageId();
                Intent intent = new Intent(MainActivity.this, MusicListActivity.class);
                intent.putExtra("genreArt", artId);
                intent.putExtra("itemPosition",position);
                startActivity(intent);
            }
        });
    }
}
