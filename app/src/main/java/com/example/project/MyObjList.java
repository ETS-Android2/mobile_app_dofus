package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project.database_dofusm.DofusMDBHandler;

import java.util.List;

public class MyObjList extends AppCompatActivity {


    private ListView mListView;
    private List<String> Objectives;
    private Intent myIntent;
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
        setContentView(R.layout.activity_my_obj_list);

        myIntent = new Intent(this, DisplayObj.class);

        mListView = (ListView) findViewById(R.id.listobj);

        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"
        Objectives = findObj();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MyObjList.this,
                android.R.layout.simple_list_item_1, Objectives);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String h = (String) parent.getItemAtPosition(position);
                String s2 = h.substring(0, h.indexOf("."));
                // get the id from the String and open a new activity displaying the character
                myIntent.putExtra("id_obj", s2);
                startActivity(myIntent);

            }
        });

    }

    public List<String> findObj(){
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        return dbHandler.getObjIntroH();
    }
}
