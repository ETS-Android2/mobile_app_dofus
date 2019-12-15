package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project.appclasses.Objectives;
import com.example.project.database_dofusm.DofusMDBHandler;

import java.sql.Date;

public class MyObj extends AppCompatActivity {

    TextView textviewob;
    EditText titob;
    EditText contob;
    EditText datob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_obj);

        textviewob = (TextView) findViewById(R.id.textView3);
        titob = (EditText) findViewById(R.id.editText12);
        contob = (EditText) findViewById(R.id.tedit);
        datob = (EditText) findViewById(R.id.editText11);
    }


    public void saveObj(View view){
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        String title = titob.getText().toString();
        String content = contob.getText().toString();
        String date = datob.getText().toString();
        dbHandler.addObjHandler(new Objectives(title, content, date, 0));
        titob.setText("");
        contob.setText("");
        datob.setText("");

    }


    public void myObjL(View view){

        Intent Objlist = new Intent(MyObj.this, MyObjList.class);
        startActivity(Objlist);

    }
}
