package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        List<String> sex = findSex();
        List<String> classes = findClasse();
        ArrayAdapter<String> adaptersex = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sex);
        ArrayAdapter<String> adapterclass = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, classes);
        c3.setAdapter(adaptersex);
        c4.setAdapter(adapterclass);
    }

    public void drop(View view) {
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        dbHandler.dropH(1,1);
    }

    public void addPerso(View view) {
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
        int id = 0;
        try { id = Integer.parseInt(c1.getText().toString().trim());}
        catch (NumberFormatException e){
        }
        dbHandler.deletePersoHandler(id);
    }

    public void findPerso(View view){
        int id = 0;
        try { id = Integer.parseInt(c1.getText().toString().trim());}
        catch (NumberFormatException e){
        }
        Personnage p = dbHandler.findPersoHandler(Integer.toString(id));
        //c1.setText(p.getName());
        c8.setText(p.getDesc());
    }

    public List<String> findSex(){
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        return dbHandler.getSexHandler();
    }

    public List<String> findClasse(){
        return dbHandler.getClassHandler();
    }
}
