package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.project.ui.login.LoginActivity;

public class MainMenu extends AppCompatActivity {


    protected boolean playingMusic = false;
    protected MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        m = MediaPlayer.create(MainMenu.this, R.raw.m);
        imageView1.setOnTouchListener(touchListenerImg);

    }

    public void loadNews(View view){

        Intent newsMenu = new Intent(MainMenu.this, NewsMenu.class);
        startActivity(newsMenu);

    }

    public void logUser(View view){

        Intent loginActivity = new Intent(MainMenu.this, LoginActivity.class);
        startActivity(loginActivity);

    }
    public void CreatePerso(View view){

        Intent loginActivity = new Intent(MainMenu.this, CreatePerso.class);
        startActivity(loginActivity);

    }

    public void Testview(View view){

        Intent loginActivity = new Intent(MainMenu.this, PersoPerso.class);
        startActivity(loginActivity);

    }

    public void myPerso(View view){

        Intent loginActivity = new Intent(MainMenu.this, MyPerso.class);
        startActivity(loginActivity);

    }
    public void myObj(View view){

        Intent loginActivity = new Intent(MainMenu.this, MyObj.class);
        startActivity(loginActivity);

    }
    private View.OnTouchListener touchListenerImg = new View.OnTouchListener() {

        final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
            public void onLongPress(MotionEvent e) {
                if(! playingMusic) {
                    m.start();
                    playingMusic = true;
                }
                else{m.pause();  playingMusic = false;}
            }
        });

        public boolean onTouch(View v, MotionEvent event) {

            return gestureDetector.onTouchEvent(event);

        };

    };

}
