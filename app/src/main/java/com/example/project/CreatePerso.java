package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.project.appclasses.Job;
import com.example.project.appclasses.Personnage;
import com.example.project.database_dofusm.DofusMDBHandler;
import com.example.project.enumdofusm.Classes;
import com.example.project.enumdofusm.JobEnum;
import com.example.project.enumdofusm.Servers;
import com.example.project.enumdofusm.Sex;

import java.util.ArrayList;
import java.util.List;

public class CreatePerso extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private Spinner s1;
    private Spinner s2;
    private EditText et3;
    private Spinner s4;
    private Spinner s5;
    private Spinner s6;
    private EditText et8;
    private EditText et9;
    private EditText et10;
    private EditText et4;
    private EditText et5;
    private EditText et6;
    private EditText et7;
    private Spinner s3;
    private EditText tiett;
    private TextView confirm;
    private DofusMDBHandler dbHandler;
    private List<String> jobex1;
    private List<String> jobex2;
    private List<String> jobex3;
    List<String> job1;
    List<String> job2;
    List<String> job3;
    ArrayAdapter<String> adapterjob1;
    ArrayAdapter<String> adapterjob2;
    ArrayAdapter<String> adapterjob3;
    String _idedit;
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
        setContentView(R.layout.activity_create_perso);


        try{
            Intent inte = getIntent();
            _idedit = inte.getStringExtra("id_perso");
        }catch (Exception e){

        }

        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        s1 = (Spinner) findViewById(R.id.spinner3);
        s2 = (Spinner) findViewById(R.id.spinner4);
        et3 = (EditText) findViewById(R.id.editText3);
        s4 = (Spinner) findViewById(R.id.spinner6);
        s5 = (Spinner) findViewById(R.id.spinner7);
        s6 = (Spinner) findViewById(R.id.spinner8);

        et8 = (EditText) findViewById(R.id.editText8);
        et9 = (EditText) findViewById(R.id.editText9);
        et10 = (EditText) findViewById(R.id.editText10);

        et4 = (EditText) findViewById(R.id.editText4);
        et5 = (EditText) findViewById(R.id.editText5);
        et6 = (EditText) findViewById(R.id.editText6);
        et7 = (EditText) findViewById(R.id.editText7);
        s3 = (Spinner) findViewById(R.id.spinner5);
        tiett = (EditText) findViewById(R.id.tiet);
        confirm = (TextView) findViewById(R.id.textView2);
        dbHandler = new DofusMDBHandler(this);

        List<String> sex = findSex();
        ArrayAdapter<String> adaptersex = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sex);
        s1.setAdapter(adaptersex);

        List<String> classes = findClasse();
        ArrayAdapter<String> adapterclass = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, classes);
        s2.setAdapter(adapterclass);

        List<String> servs = findServer();
        ArrayAdapter<String> adapterserv = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, servs);
        s3.setAdapter(adapterserv);


        job1 = findJob();
        job2 = findJob();
        job3 = findJob();
        jobex1= new ArrayList<String>();
        jobex2= new ArrayList<String>();
        jobex3= new ArrayList<String>();

        job1.remove(2);
        job2.remove(2);
        jobex3.add(job3.get(2));
        job1.remove(1);
        job3.remove(1);
        jobex2.add(job2.get(1));
        job2.remove(0);
        job3.remove(0);
        jobex1.add(job1.get(0));


        adapterjob1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, job1);
        s4.setAdapter(adapterjob1);
        s4.setOnItemSelectedListener(listup1);

        adapterjob2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, job2);
        s5.setAdapter(adapterjob2);
        s5.setOnItemSelectedListener(listup2);

        adapterjob3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, job3);
        s6.setAdapter(adapterjob3);
        s6.setOnItemSelectedListener(listup3);


    }


    private AdapterView.OnItemSelectedListener listup1 = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
           // String select = ((TextView) view ).getText().toString();

            adapterjob2.add(jobex1.get(0));
            adapterjob3.add(jobex1.get(0));
            jobex1.remove(0);

            adapterjob2.remove(s4.getSelectedItem().toString());
            adapterjob3.remove(s4.getSelectedItem().toString());
            jobex1.add(s4.getSelectedItem().toString());

            adapterjob2.notifyDataSetChanged();
            adapterjob3.notifyDataSetChanged();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


    private AdapterView.OnItemSelectedListener listup2 = new AdapterView.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            adapterjob1.add(jobex2.get(0));
            adapterjob3.add(jobex2.get(0));
            jobex2.remove(0);

            adapterjob1.remove(s5.getSelectedItem().toString());
            adapterjob3.remove(s5.getSelectedItem().toString());
            jobex2.add(s5.getSelectedItem().toString());

            adapterjob1.notifyDataSetChanged();
            adapterjob3.notifyDataSetChanged();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    

    private AdapterView.OnItemSelectedListener listup3 = new AdapterView.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            adapterjob1.add(jobex3.get(0));
            adapterjob2.add(jobex3.get(0));
            jobex3.remove(0);

            adapterjob1.remove(s6.getSelectedItem().toString());
            adapterjob2.remove(s6.getSelectedItem().toString());
            jobex3.add(s6.getSelectedItem().toString());

            adapterjob1.notifyDataSetChanged();
            adapterjob2.notifyDataSetChanged();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


    /// if thing in some_list : some_list.remove(thing)

    public void addPerso(View view) {
        String result = "";
        try {
            String name = et1.getText().toString();
            int level = Integer.parseInt(et2.getText().toString());

            if(level > 200) level = 200;

            Sex sex = Sex.valueOf(s1.getSelectedItem().toString());

            Classes cla = Classes.valueOf(s2.getSelectedItem().toString());

            int suc = Integer.parseInt(et3.getText().toString());

            if(suc > 20000) level = 20000;

            Job[] joo = {new Job(JobEnum.valueOf(s4.getSelectedItem().toString()), Integer.parseInt(et8.getText().toString())),
                    new Job(JobEnum.valueOf(s5.getSelectedItem().toString()), Integer.parseInt(et9.getText().toString())),
                    new Job(JobEnum.valueOf(s6.getSelectedItem().toString()), Integer.parseInt(et10.getText().toString()))};
            Job[] jo = joo;

            int[] car = {Integer.parseInt(et4.getText().toString()), Integer.parseInt(et5.getText().toString()), Integer.parseInt(et6.getText().toString()), Integer.parseInt(et7.getText().toString())};
            Servers serv = Servers.valueOf(s3.getSelectedItem().toString());
            String descr = tiett.getText().toString();

            Personnage perso = new Personnage(name, level, sex, cla, suc, jo, car, serv, descr);

            if (_idedit != null) {
                dbHandler.updatePersoHandler(perso);
            } else {
                long _id = dbHandler.addPersoHandler(perso);
            }
            result = "enregistrement effectué";
        }
        catch(Exception e) {

        }
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
        et6.setText("");
        et7.setText("");
        et8.setText("");
        et9.setText("");
        et10.setText("");
        tiett.setText("");
        confirm.setText(result);
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

    public List<String> findJob(){
        return dbHandler.getJobHandler();
    }
}
