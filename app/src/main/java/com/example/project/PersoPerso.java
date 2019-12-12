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

    private EditText nomClasse;
    private EditText idClasse;
    private TextView display_classe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perso_perso);
         nomClasse = (EditText) findViewById(R.id.nomClasse);
         idClasse = (EditText) findViewById(R.id.idClasse);
         display_classe = (TextView) findViewById(R.id.display_classe);
    }

    public void drop(View view) {
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        dbHandler.dropH(1,1);
    }

    public void addPerso(View view) {
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        String error = "";
        int id = 0;
        try { id = Integer.parseInt(idClasse.getText().toString().trim());}
        catch (NumberFormatException e){
        }
        String name = nomClasse.getText().toString();
        Personnage perso = new Personnage();  //id, name);
        long _id = dbHandler.addPersoHandler(perso);
        nomClasse.setText(Long.toString(_id));
        idClasse.setText(Long.toString(_id));
        display_classe.setText(name);

    }

    public void delPerso(View view){
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        int id = 0;
        try { id = Integer.parseInt(idClasse.getText().toString().trim());}
        catch (NumberFormatException e){
        }
        dbHandler.deletePersoHandler(id);
    }

    public void findPerso(View view){
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        int id = 0;
        try { id = Integer.parseInt(idClasse.getText().toString().trim());}
        catch (NumberFormatException e){
        }
        Personnage p = dbHandler.findPersoHandler(Integer.toString(id));
        nomClasse.setText(Integer.toString(p.getLevel()));
        idClasse.setText(p.getName());
        display_classe.setText(p.getAl().toString());
    }
}
