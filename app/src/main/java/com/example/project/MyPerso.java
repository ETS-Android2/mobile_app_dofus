package com.example.project;

import android.os.Bundle;

import com.example.project.appclasses.Personnage;
import com.example.project.database_dofusm.DofusMDBHandler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MyPerso extends AppCompatActivity {

    private ListView mListView;
    private List<String> personnages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_perso);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListView = (ListView) findViewById(R.id.listview2);

        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"
        personnages = findPerso();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MyPerso.this,
                android.R.layout.simple_list_item_1, personnages);
        mListView.setAdapter(adapter);

    }

    public List<String> findPerso(){
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        return dbHandler.getPersName();
    }
}
