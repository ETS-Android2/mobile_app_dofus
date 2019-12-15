package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;

public class loadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        ProgressDialog pd;
        pd = ProgressDialog.show(this,getString(R.string.wait), getString(R.string.load), false, true);
        pd.setCanceledOnTouchOutside(false);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(loadingActivity.this,MainActivity.class);
                loadingActivity.this.startActivity(mainIntent);
                loadingActivity.this.finish();
                Intent menu = new Intent(loadingActivity.this, MainMenu.class);
                startActivity(menu);

            }
        }, 3000);



    }

}
