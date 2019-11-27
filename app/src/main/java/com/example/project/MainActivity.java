package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent loading= new Intent(MainActivity.this, loadingActivity.class);
        startActivity(loading);

        try{
            Thread.sleep(2000);
        }
        catch(Exception e){}

        Intent mainMenu = new Intent(MainActivity.this, MainMenu.class);
        startActivity(mainMenu);

    }

}
