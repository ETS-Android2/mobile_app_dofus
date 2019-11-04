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

        WebView webView = (WebView) findViewById(R.id.imageWebView);
        String  data    = "<body> <img style=\"text-align:center;width:100;height:100;\" src = \"file:///android_asset/loading.gif\"/></body>";
        webView.loadDataWithBaseURL("file:///android_asset/",data,"text/html","UTF-8",null);

        Intent mainMenu = new Intent(MainActivity.this, MainMenu.class);
        startActivity(mainMenu);
    }
}
