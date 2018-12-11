package com.example.android.musicapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;


public class PlayingNowActivity extends AppCompatActivity {
    ImageView trackArt;
    ImageButton playAndPauseIB;
    TextView trackTitle;
    Intent intent;
    int trackNoInt, trackArtId;
    boolean switcher = true;
    String trackName;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_now);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        trackArt = findViewById(R.id.trackArt);
        playAndPauseIB = findViewById(R.id.play_pause);
        trackTitle = findViewById(R.id.trackNameTv);
        playAndPauseIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAndPause();
            }
        });
        intent = getIntent();
        if (intent != null) {
            Bundle bundle = getIntent().getExtras();
            assert bundle != null;
            trackArtId = bundle.getInt("playArt");
            trackName=bundle.getString("trackInfo");

        }

        trackArt.setImageResource(trackArtId);
        trackTitle.setText(trackName);
    }

    public void playAndPause() {
        if (switcher) {
            playAndPauseIB.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
            switcher = false;
        } else {
            playAndPauseIB.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
            switcher = true;
        }
    }
}
