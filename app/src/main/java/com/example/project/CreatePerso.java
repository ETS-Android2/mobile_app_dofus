package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.project.appclasses.Personnage;
import com.example.project.database_dofusm.DofusMDBHandler;
import com.example.project.enumdofusm.Classes;
import com.example.project.enumdofusm.Servers;
import com.example.project.enumdofusm.Sex;

import java.util.List;

public class CreatePerso extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private Spinner s1;
    private Spinner s2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private EditText et6;
    private EditText et7;
    private Spinner s3;
    private EditText tiett;
    private DofusMDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_perso);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        s1 = (Spinner) findViewById(R.id.spinner3);
        s2 = (Spinner) findViewById(R.id.spinner4);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        et5 = (EditText) findViewById(R.id.editText5);
        et6 = (EditText) findViewById(R.id.editText6);
        et7 = (EditText) findViewById(R.id.editText7);
        s3 = (Spinner) findViewById(R.id.spinner5);
        tiett = (EditText) findViewById(R.id.tiet);
        dbHandler = new DofusMDBHandler(this);

        Log.v("truc", findSex().toString());

//        List<String> sex = findSex();
//        ArrayAdapter<String> adaptersex = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sex);
//        s1.setAdapter(adaptersex);
//
//        List<String> classes = findClasse();
//        ArrayAdapter<String> adapterclass = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, classes);
//        s2.setAdapter(adapterclass);
//
//        List<String> servs = findServer();
//        ArrayAdapter<String> adapterserv = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, servs);
//        s3.setAdapter(adapterserv);

    }

    public void addPerso(View view) {
        String name = et1.getText().toString();
        int level = Integer.parseInt(et2.getText().toString());
        Sex sex = Sex.valueOf(s1.getSelectedItem().toString());
        Classes cla = Classes.valueOf(s2.getSelectedItem().toString());
        int suc = Integer.parseInt(et3.getText().toString());

        //Job jo = new Job(JobEnum.valueOf(job.getText().toString()), 0);

        int[] car = {Integer.parseInt(et4.getText().toString()), Integer.parseInt(et5.getText().toString()), Integer.parseInt(et6.getText().toString()), Integer.parseInt(et7.getText().toString())};
        Servers serv = Servers.valueOf(s3.getSelectedItem().toString());
        String descr = tiett.getText().toString();

        Personnage perso = new Personnage(); //name,level, sex, cla, suc, jo, car, serv, desc);
        long _id = dbHandler.addPersoHandler(perso);
    }

    public List<String> findSex(){;
        return dbHandler.getSexHandler();
    }

    public List<String> findClasse(){
        return dbHandler.getClassHandler();
    }

    public List<String> findServer(){
        return dbHandler.getServHandler();
    }
}
