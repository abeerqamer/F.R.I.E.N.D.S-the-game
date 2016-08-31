package com.example.android.friends;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * FRIENDS trivia application enjoy!!!
 */
public class MainActivity extends AppCompatActivity {


    private VideoView videoView;
    private Button play;
    private Button music;
    private MediaPlayer mediaPlayer;
    private Button exit;
    private Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TextView friends_textview = (TextView) findViewById(R.id.friends);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        if (friends_textview != null) {
            friends_textview.setTypeface(typeface);
        }

        TextView thegame = (TextView) findViewById(R.id.the_game);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        if (thegame != null) {
            thegame.setTypeface(typeface);
        }


        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.song);
        mediaPlayer.start();
        videoView = (VideoView) findViewById(R.id.videoview);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));
        videoView.setMediaController(null);

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                mp.setLooping(true);

            }
        });


        // play button will change its color when tapped!
        play = (Button) findViewById(R.id.play_button);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        play.setTypeface(typeface);
        if (play != null) {
            play.setBackgroundResource(R.drawable.play_button);
        }
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), questionDisplay.class);
                startActivity(intent);

            }
        });


        // music button will change its color when tapped!

        music = (Button) findViewById(R.id.setting_button);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        music.setTypeface(typeface);
        if (music != null) {
            music.setBackgroundResource(R.drawable.music_button);
        }

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (mediaPlayer.isPlaying()) {
                    music.setText(R.string.musicoff);
                    onPause();
                } else {
                    music.setText(R.string.musicon);
                    onStart();
                }


            }
        });


        // exit button will change its color when tapped!
        exit = (Button) findViewById(R.id.exit_button);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        exit.setTypeface(typeface);
        if (exit != null) {
            exit.setBackgroundResource(R.drawable.exit_button);

        }

        // this'll destroy the onCreate activity and releasing the mediaplayer object
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                finish();


            }
        });


    }


    // when user returns to main activity the video repeats
    @Override
    public void onResume() {
        super.onResume();

        videoView.start();

        mediaPlayer.seekTo(0);
        onStart();


    }


    @Override
    public void onStart() {
        super.onStart();
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    // when user clicks the pause button music will be muted
    @Override
    public void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.pause();

        }
    }

    // when the activity is destroyed
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


}