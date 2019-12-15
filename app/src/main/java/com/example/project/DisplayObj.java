package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.project.appclasses.Objectives;
import com.example.project.appclasses.Personnage;
import com.example.project.database_dofusm.DofusMDBHandler;

public class DisplayObj extends AppCompatActivity {

    private TextView dis;
    private TextView dis2;
    private TextView dis3;
    public static final String PREFS_NAME = "MyPrefsFile";

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
        setContentView(R.layout.activity_display_obj);

        Intent inte = getIntent();
        String _id = inte.getStringExtra("id_obj");
        dis = (TextView) findViewById(R.id.textView4);

        String [] a = showObj(Integer.parseInt(_id));

        dis2 = (TextView) findViewById(R.id.textView6);
        dis3 = (TextView) findViewById(R.id.textView7);

        dis.setText(a[0]);

        dis2.setText(a[1]);
        dis3.setText(a[2]);
    }

    public String[] showObj(int id){
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        Objectives o = dbHandler.findObjHandler(Integer.toString(id));
        refreshScreen();
        String [] a =  {o.getTitle(), o.getDate(), o.getContent()};
        return a;
    }

    public void refreshScreen(){
        dis.setText("");
    }
}
