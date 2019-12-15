package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project.database_dofusm.DofusMDBHandler;

import java.util.List;

public class MyObjList extends AppCompatActivity {


}
    private ListView mListView;
    private List<String> personnages;
    Intent myIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_obj_list);

        myIntent = new Intent(this, Display_Perso.class);

        mListView = (ListView) findViewById(R.id.listview2);

        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"
        personnages = findPerso();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MyPerso.this,
                android.R.layout.simple_list_item_1, personnages);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String h = (String) parent.getItemAtPosition(position);
                String s2 = h.substring(0, h.indexOf("."));
                // get the id from the String and open a new activity displaying the character
                myIntent.putExtra("id_perso", s2);
                startActivity(myIntent);

            }
        });

    }

    public List<String> findPerso(){
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        return dbHandler.getPersName();
    }
}
