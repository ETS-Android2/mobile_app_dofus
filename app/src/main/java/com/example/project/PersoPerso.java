package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project.appclasses.Job;
import com.example.project.appclasses.Personnage;
import com.example.project.database_dofusm.DofusMDBHandler;
import com.example.project.enumdofusm.Classes;
import com.example.project.enumdofusm.JobEnum;

public class PersoPerso extends AppCompatActivity {

    private EditText c1;
    private EditText c2;
    private EditText c3;
    private EditText c4;
    private EditText c5;
    private EditText c6;
    private EditText c7;
    private EditText c8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perso_perso);
        c1 = (EditText) findViewById(R.id.pers1);
        c2 = (EditText) findViewById(R.id.pers2);
        c3 = (EditText) findViewById(R.id.pers3);
        c4 = (EditText) findViewById(R.id.pers4);
        c5 = (EditText) findViewById(R.id.pers5);
        c6 = (EditText) findViewById(R.id.pers6);
        c7 = (EditText) findViewById(R.id.pers7);
        c8 = (EditText) findViewById(R.id.pers8);
    }

    public void drop(View view) {
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        dbHandler.dropH(1,1);
    }

    public void addPerso(View view) {
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
       // String name = c1.getText().toString();
       // int level = Integer.parseInt(lvl.getText().toString());
       // Classes cla = Classes.valueOf(classe.getText().toString());
        //int suc = Integer.parseInt(success.getText().toString());
        //Job jo = new Job(JobEnum.valueOf(job.getText().toString()), 0);

        Personnage perso = new Personnage(); //0,name,level, sex, cla, suc, jo, car, serv, desc);
        long _id = dbHandler.addPersoHandler(perso);


        c1.setText(Long.toString(_id));

    }

    public void delPerso(View view){
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        int id = 0;
        try { id = Integer.parseInt(c1.getText().toString().trim());}
        catch (NumberFormatException e){
        }
        dbHandler.deletePersoHandler(id);
    }

    public void findPerso(View view){
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        int id = 0;
        try { id = Integer.parseInt(c1.getText().toString().trim());}
        catch (NumberFormatException e){
        }
        Personnage p = dbHandler.findPersoHandler(Integer.toString(id));
        c1.setText(p.getName());
        c3.setText(Integer.toString(p.getLevel()));
        c8.setText(p.getDesc());
    }
}
