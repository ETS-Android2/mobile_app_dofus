package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.project.ui.login.LoginActivity;

public class MainMenu extends AppCompatActivity {


    protected boolean playingMusic = false;
    protected MediaPlayer m;
    protected Switch night_m;
    public static final String PREFS_NAME = "MyPrefsFile";
    protected final int pressTimeout = 5000;

    private final Handler handler = new Handler();
    private final Runnable runnable = new Runnable() {
        public void run() {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        int theme = prefs.getInt("theme", 0);


        if(theme == 1){
            setTheme(R.style.DarkAppTheme);
        }
        else{
            setTheme(R.style.AppTheme);
        }

        setContentView(R.layout.activity_main_menu);

        Switch night_m = (Switch) findViewById(R.id.switch1);
        if(theme == 1){
            night_m.setChecked(true);
        }
        else{
            night_m.setChecked(false);
        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        m = MediaPlayer.create(MainMenu.this, R.raw.m);
        imageView1.setOnTouchListener(touchListenerImg);


        night_m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences(PREFS_NAME, 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();

                if (isChecked) {
                    editor.putInt("theme", 1);
                    editor.commit();
                }
                else {
                    editor.putInt("theme", 0);
                    editor.commit();
                }
                MainMenu.this.finish();

            }
        });

    }
    protected void onStop() {
        super.onStop();
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
                else{m.stop();m.release(); m = MediaPlayer.create(MainMenu.this, R.raw.m); playingMusic = false;}
            }
        });

        public boolean onTouch(View v, MotionEvent event) {

            return gestureDetector.onTouchEvent(event);

        };

    };


}
