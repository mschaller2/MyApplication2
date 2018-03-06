package com.example.mitch.myapplication2;

import android.app.DownloadManager;
import android.app.SearchManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    public static final String EXTRA_MESSAGE = "com.example.mitch.myapplication2.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playCarl = (Button) this.findViewById(R.id.button2);
        Button stopAll = (Button) this.findViewById(R.id.button3);
        Button playSlay = (Button) this.findViewById(R.id.button4);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.carl_redbone);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.slayer_song);

        playSlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 0) {
                    mp3.start();
                }
            }
        });
        playCarl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 0) {
                    mp.start();
                }
            }
        });
        // test git
        // test git2

        stopAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.pause();
                }
                if (mp3.isPlaying()) {
                    mp3.pause();
                }
            }
        });

    }

    // called when user taps Send
    public void sendMessage(View view){

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
    public void sendMessage2(View view){

        String query = "search";
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        startActivity(intent);


    }


}
