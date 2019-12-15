package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.project.appclasses.Objectives;
import com.example.project.appclasses.Personnage;
import com.example.project.database_dofusm.DofusMDBHandler;

public class DisplayObj extends AppCompatActivity {

    private TextView dis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_obj);

        Intent inte = getIntent();
        String _id = inte.getStringExtra("id_obj");
        dis = (TextView) findViewById(R.id.textView4);
        dis.setText(showObj(Integer.parseInt(_id)));
    }

    public String showObj(int id){
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        Objectives o = dbHandler.findObjHandler(Integer.toString(id));
        refreshScreen();
        String obj = o.toString();
        return obj;
    }

    public void refreshScreen(){
        dis.setText("");
    }
}
