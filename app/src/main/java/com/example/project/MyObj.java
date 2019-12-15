package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyObj extends AppCompatActivity {

    //TextView textview3
   // EditText editText11

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_obj);
    }


    public void saveObj(View view){


    }


    public void myPerso(View view){

        Intent loginActivity = new Intent(MyObj.this, MyObjList.class);
        startActivity(loginActivity);

    }
}
