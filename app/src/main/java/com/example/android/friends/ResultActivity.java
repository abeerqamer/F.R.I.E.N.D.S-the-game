/*Copyright 2016 Android

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.**/


package com.example.android.friends;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    private Button play_again;
    private Button main_menu;
    private TextView endline;
    private TextView points_text;
    private static MediaPlayer player;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        player = MediaPlayer.create(getApplicationContext(), R.raw.end_music);
        player.start();


        play_again = (Button) findViewById(R.id.play_again_button);
        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), questionDisplay.class);
                startActivity(intent);


            }
        });


        main_menu = (Button) findViewById(R.id.main_menus);
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);


            }
        });


        TextView tv = (TextView) findViewById(R.id.point_scored);
        endline = (TextView) findViewById(R.id.end_line);


        // retrieves Bundle from MainActivity
        Bundle b = getIntent().getExtras();
        // stores the score that was passed from MainActivity
        int score = b.getInt("score");
        points_text = (TextView) findViewById(R.id.points);


        // chooses a random number from 0 till 5 and dispalys the message based on that
        Random rand = new Random();
        int value = rand.nextInt(5);

        if(value == 0)
        {
            endline.setText(R.string.chandlers);
        }
        else if(value == 1)
        {
            endline.setText(R.string.oh_mommy);
        }
        else if(value == 2)
        {
            endline.setText(R.string.how_you_doin);
        }
        else if(value == 3)
        {
            endline.setText(R.string.unagi);
        }
        else if(value == 4)
        {
            endline.setText(R.string.pivot);
        }
        else
        {
            endline.setText(R.string.sandwhich);
        }


        if(score == 1)
        {
            if (points_text != null) {
                points_text.setText(R.string.point);
            }
        }
        // displays the score in the TextView for result
        if (tv != null) {
            tv.setText(Integer.toString(score));
        }



    }



    // destroys the mediaplayer object(nullify it)
    @Override
    public void onDestroy()
    {
        super.onDestroy();

        if(player != null)
        {
            player.release();
            player = null;

        }
    }


}