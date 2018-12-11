package com.example.android.musicapp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class MusicListActivity extends AppCompatActivity {

    MusicAdapter secondAdapter;
    ArrayList<MusicInfo> secondList;
    ArrayList<MusicInfo> clssiclist;
    ArrayList<MusicInfo> countrylist;
    ArrayList<MusicInfo> electroniclist;
    ArrayList<MusicInfo> folklist;
    ArrayList<MusicInfo> frenshlist;
    ArrayList<MusicInfo> hiphoplist;
    ListView listView;
    public static int genreArtId;
    Intent intent;
    int itemPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        listView = findViewById(R.id.listview_2);
        intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("genreArt")) {
                Bundle bundle = getIntent().getExtras();
                assert bundle != null;
                genreArtId = bundle.getInt("genreArt");
                itemPosition=bundle.getInt("itemPosition");
            }
        }
        listData();
        switch (itemPosition){
            case 0:
                secondAdapter=new MusicAdapter(this, clssiclist);
                break;
            case 1:
                secondAdapter=new MusicAdapter(this, countrylist);
                break;
            case 2:
                secondAdapter=new MusicAdapter(this, electroniclist);
                break;
            case 3:
                secondAdapter=new MusicAdapter(this, folklist);
                break;
            case 4:
                secondAdapter=new MusicAdapter(this, frenshlist);
                break;
            case 5:
                secondAdapter=new MusicAdapter(this, hiphoplist);
                break;
        }
        listView.setAdapter(secondAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent2 = new Intent(MusicListActivity.this, PlayingNowActivity.class);
                intent2.putExtra("playArt", genreArtId);
                MusicInfo musicInfo= (MusicInfo) adapterView.getItemAtPosition(i);
                String trackName =musicInfo.getGenre();
                intent2.putExtra("trackInfo",trackName);
                startActivity(intent2);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    public void listData(){


        clssiclist = new ArrayList<>();
        clssiclist.add(new MusicInfo(genreArtId, "oyoon_el_alb", "Nagaat"));
        clssiclist.add(new MusicInfo(genreArtId, "khlik_hena", "Waal Gassar"));
        clssiclist.add(new MusicInfo(genreArtId, "mestnyak", "Nancy Agram"));
        clssiclist.add(new MusicInfo(genreArtId, "alf lyla w lyla", "Om Kulthom"));
        clssiclist.add(new MusicInfo(genreArtId, "amal hayati", "Om Kulthom"));
        clssiclist.add(new MusicInfo(genreArtId, "nassai", "fyrouz"));
        clssiclist.add(new MusicInfo(genreArtId, "kaab el ghazal", "Mohammed Roshdy"));
        countrylist = new ArrayList<>();
        countrylist.add(new MusicInfo(genreArtId, "People Are Crazy", "Billy Currington"));
        countrylist.add(new MusicInfo(genreArtId, "Heaven", "Kane Brown"));
        countrylist.add(new MusicInfo(genreArtId, "when it rain it pours", "Luke Combs"));
        countrylist.add(new MusicInfo(genreArtId, "mercy", "Brett Young"));
        countrylist.add(new MusicInfo(genreArtId, "she got the best of me", "Luke Combs"));
        countrylist.add(new MusicInfo(genreArtId, "simple", "Florida"));
        electroniclist = new ArrayList<>();
        electroniclist.add(new MusicInfo(genreArtId, "taki taki ft selena gomez", "dj snack"));
        electroniclist.add(new MusicInfo(genreArtId, "happier", "marshmello"));
        electroniclist.add(new MusicInfo(genreArtId, "Say My Name", "David Guetta, Bebe Rexha & J Balvin"));
        electroniclist.add(new MusicInfo(genreArtId, "beautiful feat", "Bazzi"));
        electroniclist.add(new MusicInfo(genreArtId, "happier", "Marshmello"));
        electroniclist.add(new MusicInfo(genreArtId, "say my name", "David Guetta"));
        electroniclist.add(new MusicInfo(genreArtId, "El Amante", "Nicky Jam"));
        folklist = new ArrayList<>();
        folklist.add(new MusicInfo(genreArtId, "this land is your land", "Welson"));
        folklist.add(new MusicInfo(genreArtId, "the house carpenter", "Ashly"));
        folklist.add(new MusicInfo(genreArtId, "the coo coo bird", "Claranse Ashly"));
        folklist.add(new MusicInfo(genreArtId, "we shall over come", "Beet seger"));
        folklist.add(new MusicInfo(genreArtId, "wayfaring stranger", "Jonny Cash"));
        folklist.add(new MusicInfo(genreArtId, "henry lee", "Dike Gaistes"));
        frenshlist = new ArrayList<>();
        frenshlist.add(new MusicInfo(genreArtId, "derniere danse", "Indella"));
        frenshlist.add(new MusicInfo(genreArtId, "la vie in rose", "Edeth Byaaf"));
        frenshlist.add(new MusicInfo(genreArtId, "Tous les memes", "Stromay"));
        frenshlist.add(new MusicInfo(genreArtId, "le vent nous partera", "Noir Desir"));
        frenshlist.add(new MusicInfo(genreArtId, "parlez-moi D'Amore", "Lucienne Boyer"));
        hiphoplist = new ArrayList<>();
        hiphoplist.add(new MusicInfo(genreArtId, "bad and boujee", "Migos"));
        hiphoplist.add(new MusicInfo(genreArtId, "i like it ", "Kardi Bee"));
        hiphoplist.add(new MusicInfo(genreArtId, "Pharcyde", "The Pharcyde"));
        hiphoplist.add(new MusicInfo(genreArtId, "motor sport", "Migos"));
        hiphoplist.add(new MusicInfo(genreArtId, "bodak yellow", "Kardi Bee"));






    }
}
