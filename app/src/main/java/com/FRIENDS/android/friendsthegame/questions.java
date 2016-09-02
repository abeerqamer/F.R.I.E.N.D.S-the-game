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


public class questions {

    private int id;
    private String question;
    private String answer;
    private String optionOne;
    private String optionTwo;
    private String optionThree;

    public questions() {
        id = 0;
        question = "";
        answer = "";
        optionOne = "";
        optionTwo = "";
        optionThree = "";

    }

    public questions(String dbQuestion, String dbOptionOne, String dbOptionTwo, String dbOptionThree, String dbAnswer) {
        question = dbQuestion;
        answer = dbAnswer;
        optionOne = dbOptionOne;
        optionTwo = dbOptionTwo;
        optionThree = dbOptionThree;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(String optionOne) {
        this.optionOne = optionOne;
    }

    public String getOptionTwo() {
        return optionTwo;
    }

    public void setOptionTwo(String optionTwo) {
        this.optionTwo = optionTwo;
    }

    public String getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(String optionThree) {
        this.optionThree = optionThree;
    }



}