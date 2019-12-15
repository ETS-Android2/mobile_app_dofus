package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.project.appclasses.Job;
import com.example.project.appclasses.Personnage;
import com.example.project.database_dofusm.DofusMDBHandler;
import com.example.project.enumdofusm.Classes;
import com.example.project.enumdofusm.JobEnum;

import java.sql.Array;
import java.util.List;

public class PersoPerso extends AppCompatActivity {

    private EditText c1;
    private EditText c2;
    private Spinner c3;
    private Spinner c4;
    private EditText c5;
    private EditText c6;
    private EditText c7;
    private EditText c8;
    private DofusMDBHandler dbHandler;
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        int theme = prefs.getInt("theme", 0);

        if(theme == 1){
            setTheme(R.style.DarkAppTheme);
        }
        else{
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perso_perso);
        c1 = (EditText) findViewById(R.id.pers1);
        c2 = (EditText) findViewById(R.id.pers2);
        c3 = (Spinner) findViewById(R.id.spinner);
        c4 = (Spinner) findViewById(R.id.spinner2);
        c5 = (EditText) findViewById(R.id.pers5);
        c6 = (EditText) findViewById(R.id.pers6);
        c7 = (EditText) findViewById(R.id.pers7);
        c8 = (EditText) findViewById(R.id.pers8);
        dbHandler = new DofusMDBHandler(this);
    }

    public void drop(View view) {
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        dbHandler.dropH(1,1);
    }


}
