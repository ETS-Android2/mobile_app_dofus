package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project.appclasses.Personnage;
import com.example.project.database_dofusm.DofusMDBHandler;

public class PersoPerso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perso_perso);
    }

    public void loadStudents(View view) {
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        //lst.setText(dbHandler.loadHanler());
       // studentid.setText("");
       // studentname.setText("");
    }

    public void addPerso(View view) {
        EditText nomClasse = (EditText) findViewById(R.id.nomClasse);
        EditText idClasse = (EditText) findViewById(R.id.idClasse);
        TextView display_classe = (TextView) findViewById(R.id.display_classe);
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);

        String error = "";
        int id = 0;
        try { id = Integer.parseInt(idClasse.getText().toString().trim());}
        catch (NumberFormatException e){
        }
        String name = nomClasse.getText().toString();
        Personnage perso = new Personnage();  //id, name);
        dbHandler.addPersoHandler(perso, null);
        nomClasse.setText("");
        idClasse.setText(error);
        display_classe.setText(name);

    }

    public void findPerso(View view){
        EditText nomClasse = (EditText) findViewById(R.id.nomClasse);
        EditText idClasse = (EditText) findViewById(R.id.idClasse);
        TextView display_classe = (TextView) findViewById(R.id.display_classe);
       /// DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        int id = 0;
        try { id = Integer.parseInt(idClasse.getText().toString().trim());}
        catch (NumberFormatException e){
        }
        Personnage p = new Personnage(); //dbHandler.findPersoHandler(Integer.toString(id));

        nomClasse.setText(Integer.toString(p.getLevel()));
        idClasse.setText(p.getName());
        display_classe.setText(p.getAl().toString());
    }
}
