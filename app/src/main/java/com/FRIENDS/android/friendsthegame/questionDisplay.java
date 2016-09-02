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


import android.support.v7.app.AppCompatActivity;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import android.os.Handler;

import com.example.android.friends.R;


public class questionDisplay extends AppCompatActivity {

    // bunch of instance variables

    int score = 0;
    int qid = 0;
    private MediaPlayer player;
    private MediaPlayer answer_sound;
    private List<questions> qaList;
    private long timePassed = 0;
    private questions currentQuestion;
    private Button option1;
    private Button option2;
    private Button option3;
    private TextView ques;
    private TextView start_timer;
    private TextView questionTimer;
    private TextView timer_up;
    private CustomTimer timer;

    // this'll inflate the back/up button so user can go to the main activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_display);
        player = MediaPlayer.create(getApplicationContext(), R.raw.rumbler);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        if (player != null) {
            player.start();

        }


        databaseHelper db = new databaseHelper(this);
        qaList = db.getAllQuestions();
        currentQuestion = qaList.get(qid);
        option1 = (Button) findViewById(R.id.option1);
        option2 = (Button) findViewById(R.id.option2);
        option3 = (Button) findViewById(R.id.option3);
        ques = (TextView) findViewById(R.id.question_textview);
        start_timer = (TextView) findViewById(R.id.starter_timer);
        questionTimer = (TextView) findViewById(R.id.timer_id);
        timer_up = (TextView) findViewById(R.id.time_up);
        option1.setVisibility(View.INVISIBLE);
        option2.setVisibility(View.INVISIBLE);
        option3.setVisibility(View.INVISIBLE);
        ques.setVisibility(View.INVISIBLE);
        questionTimer.setVisibility(View.INVISIBLE);
        timer_up.setVisibility(View.INVISIBLE);


        // the initial countdown after start button has pressed

        new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long milliseconds) {


                start_timer.setText(String.valueOf(milliseconds / 1000));
            }

            @Override
            public void onFinish() {


                setQAView();
                questionTimer.setVisibility(View.VISIBLE);
                start_timer.setVisibility(View.GONE);
                ques.setVisibility(View.VISIBLE);
                Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
                ques.setTypeface(typeface1);
                option1.setVisibility(View.VISIBLE);
                option2.setVisibility(View.VISIBLE);
                option3.setVisibility(View.VISIBLE);

            }
        }.start();


        questionTimer = (TextView) findViewById(R.id.timer_id);
        timer_up = (TextView) findViewById(R.id.time_up);


        timer = new CustomTimer(65000, 1000);
        timer.start();


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentQuestion.getAnswer().equals(option1.getText())) {
                    score++;
                    option1.setBackgroundResource(R.drawable.right_answer);
                    soundManager("correct");


                    option1.setEnabled(false);

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {


                            option1.setBackgroundResource(R.color.option_button);
                            option1.setEnabled(true);


                        }
                    }, 500);


                    check_if_done();


                } else {
                    option1.setBackgroundResource(R.drawable.wrong_answer);
                    soundManager("wrong");
                    option1.setEnabled(false);


                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {

                            option1.setBackgroundResource(R.color.option_button);
                            option1.setEnabled(true);


                        }
                    }, 500);


                    send_to_result();


                }


            }
        });

        option2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if (currentQuestion.getAnswer().equals(option2.getText())) {
                    score++;
                    option2.setBackgroundResource(R.drawable.right_answer);
                    soundManager("correct");
                    option2.setEnabled(false);

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {

                            option2.setBackgroundResource(R.color.option_button);
                            option2.setEnabled(true);


                        }
                    }, 500);


                    check_if_done();


                } else {

                    option2.setBackgroundResource(R.drawable.wrong_answer);
                    soundManager("wrong");
                    option2.setEnabled(false);


                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {

                            option2.setBackgroundResource(R.color.option_button);
                            option2.setEnabled(true);


                        }
                    }, 500);


                    send_to_result();

                }


            }
        });

        option3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if (currentQuestion.getAnswer().equals(option3.getText())) {
                    score++;
                    option3.setBackgroundResource(R.drawable.right_answer);
                    soundManager("correct");
                    option3.setEnabled(false);


                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {

                            option3.setBackgroundResource(R.color.option_button);
                            option3.setEnabled(true);


                        }
                    }, 500);


                    check_if_done();


                } else {
                    option3.setBackgroundResource(R.drawable.wrong_answer);
                    soundManager("wrong");
                    option3.setEnabled(false);


                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            // return true on correct & false on incorrect
                            option3.setBackgroundResource(R.color.option_button);
                            option3.setEnabled(true);


                        }
                    }, 500);


                    send_to_result();

                }


            }
        });


    }


    // when media player is stopped then nullify it saves memory
    @Override
    public void onStop() {
        super.onStop();
        player.stop();
        player.release();
        player = null;

    }


    // checks whether the user chose the right answer if yes then continue to next question otherwise show result
    public void check_if_done() {


        databaseHelper helper = new databaseHelper(this);

        if (qid < helper.rowCount()) {

            currentQuestion = qaList.get(qid);
            new CountDownTimer(500, 500) {
                @Override
                public void onTick(long milliseconds) {
                }

                @Override
                public void onFinish() {

                    setQAView();
                }
            }.start();


        } else {
            // creates intent for launching the result screen

            send_to_result();
        }


    }

    public void send_to_result() {

        timer.cancel();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent intent = new Intent(questionDisplay.this, ResultActivity.class);
                Bundle b = new Bundle();
                // puts the score in a Bundle so it can be passed to the ResultActivity
                b.putInt("score", score);
                // puts the Bundle into the Intent
                intent.putExtras(b);
                // starts the ResultActivity with score values stored
                startActivity(intent);
                finish();

            }
        }, 1000);


    }


    private void setQAView() {


        if (timePassed > 0) {
            ques.setText(currentQuestion.getQuestion());
            option1.setText(currentQuestion.getOptionOne());
            option2.setText(currentQuestion.getOptionTwo());
            option3.setText(currentQuestion.getOptionThree());
            qid++;

        } else {
            option1.setVisibility(View.GONE);
            option2.setVisibility(View.GONE);
            option3.setVisibility(View.GONE);
            ques.setVisibility(View.GONE);


        }

    }

    // manages the right and wrong sound
    public void soundManager(String message) {

        if (answer_sound != null) {
            answer_sound.reset();
            answer_sound.release();
        }

        if (message.equals("correct")) {
            answer_sound = MediaPlayer.create(this, R.raw.correct);

        } else if (message.equals("wrong")) {
            answer_sound = MediaPlayer.create(this, R.raw.wrong);

        }

        if (answer_sound != null) {
            answer_sound.start();

        }
    }

    public class CustomTimer extends CountDownTimer {

        public CustomTimer(long millisInFuture, long countDownInterval) {

            super(millisInFuture, countDownInterval);

        }

        // when the clock is tickling update the text of timer tick tock tick tock...
        @Override
        public void onTick(long milliseconds) {
            milliseconds = milliseconds / 1000;
            timePassed = milliseconds;
            Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
            start_timer.setTypeface(typeface);
            questionTimer.setText(String.valueOf(milliseconds));

            if (milliseconds <= 5) {
                questionTimer.setTextColor(Color.RED);
            }


        }

        @Override
        public void onFinish() {
            questionTimer.setText("0");
            timer_up.setVisibility(View.VISIBLE);
            float endSize = 50;
            float startSize = 20;
            ValueAnimator animator = ValueAnimator.ofFloat(startSize, endSize);
            int animationDuration = 500;
            animator.setDuration(animationDuration);


            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedValue = (float) valueAnimator.getAnimatedValue();
                    timer_up.setTextSize(animatedValue);
                }
            });


            player = MediaPlayer.create(getApplicationContext(), R.raw.horn);
            player.start();


            animator.start();
            send_to_result();


        }


    }

}




