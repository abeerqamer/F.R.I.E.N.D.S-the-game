
/*Copyright 2016 Android

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License. **/


package com.example.android.friends;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class databaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "triviaQuiz";
    private static final String TABLE_QUEST = "quest";
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_OPTA = "opta";
    private static final String KEY_OPTB = "optb";
    private static final String KEY_OPTC = "optc";
    private SQLiteDatabase dbase;

    // DbHelper constructor
    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        // Set SQLite database parameters
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sql);
        addQuestions();
    }

    // create the questions and use the addQuestion method to add them to the database
    private void addQuestions() {

        questions q1 = new questions("What is Chandler's last name?","Bing", "Tribianni", "Muriel","Bing");
        this.addQuestion(q1);

        questions q2 = new questions("Which Rachel’s boyfriend made a move on Phoebe in season 1 ?", "Barry", "Gavin", "Paolo", "Paolo");
        this.addQuestion(q2);
        questions q3 = new questions("Which table did Joey and Chandler bought finally ?", "Wooden Table", "Foosball Table", "Pinball Table", "Foosball Table");
        this.addQuestion(q3);
        questions q4 = new questions("In season 1,who Accidently saw Rachel’s breast ?", "Phoebe", "Joey", "Chandler", "Chandler");
        this.addQuestion(q4);

        questions q5 = new questions("Which three letters did Marcel swallowed ?", "A,B, C", "M,K,O", "M,N,K", "M,K,O");
        this.addQuestion(q5);

        questions q6 = new questions("What is the name of Marcel’s favourite song ?", "Lion Sleeps Tonight", "Endless Love", "Nothing Else Matters", "Lion Sleeps Tonight");
        this.addQuestion(q6);

        questions q7 = new questions("Which character ran from their marriage altar ?", "Rachel", "Monica", "Phoebe", "Rachel");
        this.addQuestion(q7);

        questions q8 = new questions("Why did Ross have to give up on Marcel ?", "Sexual Maturity", "Government Laws", "Because Monica wants to", "Sexual Maturity");
        this.addQuestion(q8);

        questions q9 = new questions("In season 1 which science study did Joey contributed ?", "Fertility Study", "Life Science", "Physical Science", "Fertility Study");
        this.addQuestion(q9);

        questions q10 = new questions("Who discloses that Ross love Rachel ?", "Joey", "Chandler", "Monica", "Chandler");
        this.addQuestion(q10);

        questions q11 = new questions("Chandler stuck in a vestibule with which actress?", "Amy Goodacre", "Jill Acuff", "Jill Goodacre", "Jill Goodacre");
        this.addQuestion(q11);

        questions q12 = new questions("Rachel use to compare her life to ?","Shoes & Hats","Knife & Stick","Purse & Perfumes","Shoes & Hats");
        this.addQuestion(q12);

        questions q13 = new questions("What is Joey usual opening lines ?","Howdy","What's up buddy","How you Doin ?","How you Doin ?");
        this.addQuestion(q13);

        questions q14 = new questions("Why did Ross break up with Carol ?", "She became mental", "She love someone else", "Because she was lesbian", "Because she was lesbian");
        this.addQuestion(q14);

        questions q15 = new questions("What was the color of Monica's dress when she got engaged ?", "Black", "Blue", "Green", "Black");
        this.addQuestion(q15);

        questions q16 = new questions("What day did Friends premiered ?", "September 24th 1994", "September 22nd 1994", "September 25th 1994", "September 22nd, 1994");
        this.addQuestion(q16);

        questions q17 = new questions("Which guest celebrity donated all his money he got from FRIENDS to charity ?", "Christina Applegate", "Reese Witherspoon", "Bruce Willis", "Bruce Willis");
        this.addQuestion(q17);

        questions q18 = new questions("The infamous big white dog in Chandlers and Joey’s apartment was given to which cast member as a good luck ?", "Rachel", "Monica", "Ross", "Rachel");
        this.addQuestion(q18);

        questions q19 = new questions("What is the name of Monica and Ross’s grandmother ?", "Judy", "Althea", "Sylvia", "Althea");
        this.addQuestion(q19);

        questions q20 = new questions("What name appears on the address label of Chandler and joey’s TV guide?", "Mr Chandler Bing", "Mr.s Chanandler Bong", "Ms Chanandler Bong", "Ms Chanandler Bong");
        this.addQuestion(q20);

        questions q21 = new questions("What is Monica’s nick name when she was a field goalie ?", "Big Fat Goalie", "Big Goalie", "Goalie", "Big Fat Goalie");
        this.addQuestion(q21);

        questions q22 = new questions("What is Rachel's actual favorite movie ?", "American Beauty", "Weekend At Barney's", "Angel's Dance", "Weekend At Barney's");
        this.addQuestion(q22);

        questions q23 = new questions("How many categories did Monica categorizes her towels", "10", "12", "11", "11");
        this.addQuestion(q23);

        questions q24 = new questions("What is joey’s favourite food ?", "Sandwiches", "Chinese Food", "Hamburger", "Sandwiches");
        this.addQuestion(q24);

        questions q25 = new questions("What is the name of Joey’s imaginary friend ?", "Murial", "Maurice", "Vincent", "Maurice");
        this.addQuestion(q25);

        questions q26 = new questions("What was the joey’s imaginary friend's profession ?", "Business Man", "Actor", "Space Cowboy", "Space Cowboy");
        this.addQuestion(q26);

        questions q27 = new questions("What did Phoebe dress up as in Monica and Chandler's Halloween party ?", "Super Girl", "Bat Women", "Ghost", "Super Girl");
        this.addQuestion(q27);

        questions q28 = new questions("Which famous person does Phoebe believes is her Grandfather ?", "Isaac Newton", "Albert Einstein", "Amedeo Avagadro", "Albert Einstein");
        this.addQuestion(q28);

        questions q29 = new questions("Why did Monica and Rachel lost the apartment ?", "they got robbed ", "Because they lost the quiz", "They give it away to Mr.Heckeles", "Because they lost the quiz");
        this.addQuestion(q29);

        questions q30 = new questions("What happened to Monica on her 30th birthday ?", "She got fired", "She had sex", "She got drunk", "She got drunk");
        this.addQuestion(q30);

        questions q31 = new questions("Chandler fell in love with which Joey's girlfriend ?", "Anjela", "Janine", "Kathy", "Kathy");
        this.addQuestion(q31);

        questions q32 = new questions("When Phoebe changed her name to Princess Consuela then what did Mike change his name to ?", "Crap Bag", "Prince Mike", "Shit Bag", "Crap Bag");
        this.addQuestion(q32);

        questions q33 = new questions("What did Monica's parents call her as a child ?", "Harmonica", "Little Harmonica", "Fat Harmonica", "Little Harmonica");
        this.addQuestion(q33);

        questions q34 = new questions("What fruit is Ross allergic to ?", "Apple", "Orange", "Kiwi", "Kiwi");
        this.addQuestion(q34);

        questions q35 = new questions("Which Friend hates thanksgiving ?", "Chandler", "Phoebe", "Ross", "Chandler");
        this.addQuestion(q35);

        questions q36 = new questions("Why Chandler hates thanksgiving ?", "Because he got divorce in Thanksgiving", "Because his parents got divorced in thanksgiving", "He just hates it", "Because his parent got divorce in thanksgiving");
        this.addQuestion(q36);

        questions q37 = new questions("What are Phoebe and Joey's all purpose aliases ?", "Regeen Phalange & Ken Adams", "Regina Phalange & Kane Adams", "Regina Phalange & Ken Adams", "Regina Phalange & Ken Adams");
        this.addQuestion(q37);

        questions q38 = new questions("Which dollhouse item was Monica trying to show off when everybody was looking at Phoebe's dollhouse?", "China Cabinet", "China Table", "Cabinet", "China Cabinet");
        this.addQuestion(q38);

        questions q39 = new questions("Emily told Ross that someone was not wearing a cup in the Rugby game, what was his name?", "Kavin", "David", "Mark", "David");
        this.addQuestion(q39);

        questions q40 = new questions("What is the name of Monica and Chandler's kids ? ","Erwin & Erica","Phoebe & Phoebo","Jack & Erica","Jack & Erica");
        this.addQuestion(q40);

        questions q41 = new questions("What type of wine was Emma's babysitter drinking at Phoebe's Birthday Dinner?", "Sangiovese", "Malbec", "Chardonnay", "Chardonnay");
        this.addQuestion(q41);

        questions q42 = new questions("Which airline did the gang used to travel England?", "Virgin Airlines", "British Airlines", "American Airlines", "Virgin Airlines");
        this.addQuestion(q42);

        questions q43 = new questions("What is the name of Monica’s imaginary boyfriend  in high school ?", "Mark", "Jared", "David", "Jared");
        this.addQuestion(q43);

        questions q44 = new questions("Who stole the insole from chandler’s shoes ?", "Joey", "Ross", "Eddie", "Eddie");
        this.addQuestion(q44);

        questions q45 = new questions("What is the name of the place where Ursula works ?", "Riff's", "MoonLight Dance", "Tuff's", "Riff's");
        this.addQuestion(q45);

        questions q46 = new questions("What is the name of Eddie’s girlfriend ?", "Merry", "Tilly", "Amy", "Tilly");
        this.addQuestion(q46);

        questions q47 = new questions("Which union is joey member of ?", "Days Of Our Lives", "Screen Actors Guild", "Acting Society", "Screen Actors Guild");
        this.addQuestion(q47);

        questions q48 = new questions("Emily asked Ross not see ______ again. ", "Monica", "Carol", "Rachel", "Rachel");
        this.addQuestion(q48);

        questions q49 = new questions("What message is displayed when Ross shake the magic 8 ball ?", "Ask again later", "Marry Emily", "Leave Rachel", "Ask again later");
        this.addQuestion(q49);

        questions q50 = new questions("What is the name of Rachel's childhood dog ?", "Tyson", "Lapooh", "Jack", "Lapooh");
        this.addQuestion(q50);

        questions q51 = new questions("Who did Monica & Rachel fogged in season 5?", "Jack", "David", "Danny", "Danny");
        this.addQuestion(q51);

        questions q52 = new questions("Which animal does Chandler hates ?", "Dog", "Cat", "Horse", "Dog");
        this.addQuestion(q52);

        questions q53 = new questions("What Ross doesn't like?", "Candies", "Ice Cream", "Chocolate", "Ice Cream");
        this.addQuestion(q53);

        questions q54 = new questions("What is the name of the assistant that Rachel had a crush on ?", "Ralph", "Paul", "Tag", "Tag");
        this.addQuestion(q54);

        questions q55 = new questions("What did Ross bought for Phoebe on her birthday ?", "Bicycle", "Video Game", "Stuff Toys", "Bicycle");
        this.addQuestion(q55);

        questions q56 = new questions("What Monica did in order to know her neighborhood ?", "Went to everyone's apartment", "Made Candies", "Invite everyone to her apartment", "Made Candies");
        this.addQuestion(q56);

        questions q57 = new questions("What outfit did Ross got before Christmas to teach Ben about hanukkah ?", "Santa Clause", "Micky Mouse", "Holiday Armadillo", "Holiday Armadillo");
        this.addQuestion(q57);

        questions q58 = new questions("According to Rachel and Chandler which bakery makes the best cheese cake ?", "Mama's Little Bakery", "United Bakery", "Cheese House Bakery", "Mama's Little Bakery");
        this.addQuestion(q58);

        questions q59 = new questions("When Ross and Joey stuck on the roof what did they used to get down ?", "Stairs", "Fire Escape", "Pipes", "Fire Escape");
        this.addQuestion(q59);

        questions q60 = new questions("What is the name of Joey’s sofa ? ", "Rose", "Rossy", "Rosita", "Rosita");
        this.addQuestion(q60);

        questions q61 = new questions("What is the name of Joey’s tv ?", "Stevie", "Rosita", "Sammy", "Stevie");
        this.addQuestion(q61);

        questions q62 = new questions("Monica and Ross's dad puts whose stuff to protect his Porsche from flood?", "Ross", "Monica", "Judy", "Monica");
        this.addQuestion(q62);

        questions q63 = new questions("Who got drunk on his/her 30th birthday ?", "Ross", "Joey", "Monica", "Monica");
        this.addQuestion(q63);

        questions q64 = new questions("What is the name of the soap opera in which Joey works ?", "Days Of Our Lives", "Days Of Lives", "The Days Of Our Lives", "Days Of Our Lives");
        this.addQuestion(q64);

        questions q65 = new questions("what instrument was Ross planning to play at Monica & Chandler'S wedding ?", "Piano", "Bag pipes", "Guitar", "Bag pipes");
        this.addQuestion(q65);

        questions q66 = new questions("Who taught Ben childhood tricks ?", "Phoebe", "Chandler", "Rachel", "Rachel");
        this.addQuestion(q66);

        questions q67 = new questions("Who Monica is actually looking for in London when she was sad ?", "Joey", "Chandler", "Ross", "Joey");
        this.addQuestion(q67);

        questions q68 = new questions("What band did Chandler wants to invite in his wedding ?", "Babyshambles", "The Swings", "Metallica", "The Swings");
        this.addQuestion(q68);

        questions q69 = new questions("In which award Joey got nominated ?", "Oscar", "National Film Awards", "Soapie", "Soapie");
        this.addQuestion(q69);

        questions q70 = new questions("In which category did Joey get nominated ?", "Favorite Returning Character", "Best Actor", "Favorite Character", "Favorite Returning Character");
        this.addQuestion(q70);

        questions q71 = new questions("Whose father is gay ?", "Joey", "Chandler", "Rachel", "Chandler");
        this.addQuestion(q71);

        questions q72 = new questions("Which costume did Ross wear at the Halloween party ?", "SuperMan", "SpiderMan", "Sputnik", "Sputnik");
        this.addQuestion(q72);

        questions q73 = new questions("Who cleans during their sleep ?", "Phoebe", "Rachel", "Monica", "Monica");
        this.addQuestion(q73);

        questions q74 = new questions("Who co-founded I hate Rachel club ?", "Ross", "Joey", "Gunther", "Ross");
        this.addQuestion(q74);

        questions q75 = new questions("Ross co-founded which club in high school ?", "Fighting Club", "I hate Rachel club", "Study Club", "I hate Rachel club");
        this.addQuestion(q75);

        questions q76 = new questions("What wedding present did Phoebe bought for Monica & Chandler ?", "Guitar", "Big White Dog", "PacMan Machine", "PacMan Machine");
        this.addQuestion(q76);

        questions q77 = new questions("What name does Phoebe suggests for Rachel's baby ?", "Phoebe and Phoebo", "Ben and Emma", "David and Mathew", "Phoebe and Phoebo");
        this.addQuestion(q77);

        questions q78 = new questions("To whom did Joey first told about his feeling for Rachel ?", "Ross", "Phoebe", "Chandler", "Phoebe");
        this.addQuestion(q78);

        questions q79 = new questions("What is the name of the guy Phoebe thinks that he'll be the soul mate of Monica ?", "Chandler", "David", "Don", "Don");
        this.addQuestion(q79);

        questions q80 = new questions("what is the name of the Geller's dog ?", "Lapooh", "Chi Chi", "Tyson", "Chi Chi");
        this.addQuestion(q80);

        questions q81 = new questions("Who proposed to Rachel in the hospital ?", "Ross", "Tag", "Joey", "Joey");
        this.addQuestion(q81);

        questions q82 = new questions("In season 9 who was having sex in hospital closet ?", "Ross & Rachel", "Monica & Chandler", "Joey & Rachel", "Monica & Chandler");
        this.addQuestion(q82);

        questions q83 = new questions("In which country Chandler got transferred ?", "China", "Yemen", "Tulsa", "Tulsa");
        this.addQuestion(q83);

        questions q84 = new questions("What is Monica and Ross pediatrician name ?", "Dr. Gettleman", "Dr. Clooney", "Dr. Wyle", "Dr. Gettleman");
        this.addQuestion(q84);

        questions q85 = new questions("In season 9,where did Joey met Mike ?", "Theatre", "Central Perk", "Nick's Game", "Central Perk");
        this.addQuestion(q85);

        questions q86 = new questions("what Monica thought when she surprises chandler in Tulsa ?", "She got in wrong apartment", "Chandler is watching shark porn", "Chandler is with some other women", "Chandler is watching shark porn");
        this.addQuestion(q86);

        questions q87 = new questions("What song did Ross sang to made Emma laugh ?", "Twinkle Twinkle Little Star", "Lion Sleep Tonight", "Baby Got Back", "Baby Got Back");
        this.addQuestion(q87);

        questions q88 = new questions("What is the name of the girl Rachel and Ross hired as a nanny ?", "Emily", "Anjela", "Molly", "Molly");
        this.addQuestion(q88);

        questions q89 = new questions("What is the name of Rachel’s assistant that she use to like ?", "David", "Tag", "Ralph", "Tag");
        this.addQuestion(q89);

        questions q90 = new questions("What is the name of the comic book which Ross had in his childhood ?", "Dinosaur Boy", "Geller Boy", "Science Boy", "Science Boy");
        this.addQuestion(q90);

        questions q91 = new questions("Who mugged Ross in his childhood ?", "Phoebe", "Phoebe's Friend", "Gandalf", "Phoebe");
        this.addQuestion(q91);

        questions q92 = new questions("For which lipstick company did Joey did a commercial ?", "Guerlain", "Ichibaan", "MAC", "Ichibaan");
        this.addQuestion(q92);

        questions q93 = new questions("Where did Phoebe and Mike gave their wedding money ?", " to a poor man", "Lottery", "Charity", "Charity");
        this.addQuestion(q93);

        questions q94 = new questions("In which competition did Rachel and Phoebe put Emma on ?", "Baby Beauty pageant", "Smart Baby", "Youngest Baby", "Baby Beauty pageant");
        this.addQuestion(q94);

        questions q95 = new questions("What profession did Chandler chose to tell Erica ?", "Actor", "Business Man", "Doctor", "Doctor");
        this.addQuestion(q95);

        questions q96 = new questions("What profession did Monica chose to tell Erica?", "Cook", "Reverend", "Singer", "Reverend");
        this.addQuestion(q96);

        questions q97 = new questions("Who was Nancy that Phoebe and Rachel misunderstood as Chandler's girlfriend ?", "Stripper", "Chandler's Friend", "Realtor", "Realtor");
        this.addQuestion(q97);

        questions q98 = new questions("Who break the pact in high school between Chandler and Ross ?", "Chandler", "Ross", "Both", "Both");
        this.addQuestion(q98);

        questions q99 = new questions("Who was Monica’s midnight mystery kisser ?", "Ross", "Chandler", "Joey", "Ross");
        this.addQuestion(q99);

        questions q100 = new questions("Which language according to Joey can speak fluently but in reality he can’t ?", "Spanish", "French", "Chinese", "French");
        this.addQuestion(q100);

        questions q101 = new questions("In season 10 Phoebe changes her name to  ?", "Regeen Phalange", "Emma Bananahammock", "Princess Consuela Bananahammock", "Princess Consuela Bananahammock");
        this.addQuestion(q101);

        questions q102 = new questions("Chandler founded a handcuff, who does it belongs to ?", "Monica", "Monica's Mother", "Monica's Grandmother", "Monica's Grandmother");
        this.addQuestion(q102);


        questions q103 = new questions("What is Monica's catchphrase ?", "Oh my God", "Holy hell", "I KNOW", "I KNOW");
        this.addQuestion(q103);


        questions q104 = new questions("For how many season's did Friends run for ?", "10", "20", "11", "10");
        this.addQuestion(q104);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        onCreate(db);
    }

    // reads
    public void addQuestion(questions quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQuestion());
        values.put(KEY_ANSWER, quest.getAnswer());
        values.put(KEY_OPTA, quest.getOptionOne());
        values.put(KEY_OPTB, quest.getOptionTwo());
        values.put(KEY_OPTC, quest.getOptionThree());

        dbase.insert(TABLE_QUEST, null, values);
    }

    // gets all questions and adds them to an ArrayList to be used by MainActivity
    public List<questions> getAllQuestions() {
        List<questions> qaList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);


        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    questions quest = new questions();
                    quest.setId(cursor.getInt(0));
                    quest.setQuestion(cursor.getString(1));
                    quest.setAnswer(cursor.getString(2));
                    quest.setOptionOne(cursor.getString(3));
                    quest.setOptionTwo(cursor.getString(4));
                    quest.setOptionThree(cursor.getString(5));
                    qaList.add(quest);
                    Collections.shuffle(qaList);
                } while (cursor.moveToNext());

                cursor.close();
                dbase.close();
            }
        }


        return qaList;
    }


    // returns the number of  questions
    public int rowCount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        cursor.close();
        return row;
    }


}