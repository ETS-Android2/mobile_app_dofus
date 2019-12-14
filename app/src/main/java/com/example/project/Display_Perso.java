package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.project.appclasses.Personnage;
import com.example.project.database_dofusm.DofusMDBHandler;

public class Display_Perso extends AppCompatActivity {

    TextView dis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__perso);
        Intent inte = getIntent();
        String _id = inte.getStringExtra("id_perso");
        dis = (TextView) findViewById(R.id.textView5);
        dis.setText(showPerso(Integer.parseInt(_id)));
    }

    public String showPerso(int id){
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        Personnage p = dbHandler.findPersoHandler(Integer.toString(id));
        refreshScreen();
        String pers = p.toString();
        return pers;
    }

    public void refreshScreen(){
        dis.setText("");
    }


}
