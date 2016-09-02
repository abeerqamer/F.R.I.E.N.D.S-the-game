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


package com.FRIENDS.android.friendsthegame;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.friends.R;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    MediaPlayer player;
    private Button play_again;
    private Button main_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        player = MediaPlayer.create(getApplicationContext(), R.raw.end_music);
        player.start();


        play_again = (Button) findViewById(R.id.play_again_button);
        if (play_again != null) {
            play_again.setBackgroundResource(R.drawable.button_pink);

        }
        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), questionDisplay.class);
                startActivity(intent);
                finish();


            }
        });


        main_menu = (Button) findViewById(R.id.main_menus);
        if (main_menu != null) {
            main_menu.setBackgroundResource(R.drawable.button_pink);

        }
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();


            }
        });


        // retrieves Bundle from MainActivity
        Bundle b = getIntent().getExtras();
        // stores the score that was passed from question display activity
        int score = b.getInt("score");

        TextView points_text = (TextView) findViewById(R.id.points);

        // when score is is 1 change points to point to correct grammar
        if (score == 1) {
            if (points_text != null) {
                points_text.setText(R.string.point);
            }
        }

        TextView scores = (TextView) findViewById(R.id.point_scored);

        // displays the score in the TextView for result
        if (scores != null) {
            scores.setText(String.valueOf(score));
        }


        TextView endline = (TextView) findViewById(R.id.end_line);

        Random r = new Random();
        int Low = 1;
        int High = 17;
        int value = r.nextInt(High - Low) + Low;

        switch (value) {
            case 1:
                value = 1;
                if (endline != null)
                    endline.setText(R.string.pivots);
                break;

            case 2:
                value = 2;
                if (endline != null)
                    endline.setText(R.string.monkey);
                break;

            case 3:
                value = 3;
                if (endline != null)
                    endline.setText(R.string.duck);
                break;

            case 4:
                value = 4;
                if (endline != null)
                    endline.setText(R.string.pivot);
                break;

            case 5:
                value = 5;
                if (endline != null)
                    endline.setText(R.string.sandwhich);
                break;

            case 6:
                value = 6;
                if (endline != null)
                    endline.setText(R.string.chandlers);
                break;

            case 7:
                value = 7;
                if (endline != null)
                    endline.setText(R.string.gallon_of_milk);
                break;

            case 8:
                value = 8;
                if (endline != null)
                    endline.setText(R.string.turkey);
                break;

            case 9:
                value = 9;
                if (endline != null)
                    endline.setText(R.string.lobster);
                break;

            case 10:
                value = 10;
                if (endline != null)
                    endline.setText(R.string.never_fails);
                break;

            case 11:
                value = 11;
                if (endline != null)
                    endline.setText(R.string.jellyfish);
                break;

            case 12:
                value = 12;
                if (endline != null)
                    endline.setText(R.string.altar);
                break;

            case 13:
                value = 13;
                if (endline != null)
                    endline.setText(R.string.hand_twin);
                break;

            case 14:
                value = 14;
                if (endline != null)
                    endline.setText(R.string.onABreak);
                break;

            case 15:
                value = 15;
                if (endline != null)
                    endline.setText(R.string.trifle);
                break;

            case 16:
                value = 16;
                if (endline != null)
                    endline.setText(R.string.chandlers);
                break;

            case 17:
                value = 17;
                if (endline != null)
                    endline.setText(R.string.yemen);
                break;


        }


    }


    @Override
    public void onStop() {
        super.onStop();

        if (player != null) {
            player.release();
            player = null;

        }
    }


}

