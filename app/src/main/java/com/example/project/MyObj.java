package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyObj extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_obj);
    }



    public void myPerso(View view){

        Intent loginActivity = new Intent(MyObj.this, MyObjList.class);
        startActivity(loginActivity);

    }
}
