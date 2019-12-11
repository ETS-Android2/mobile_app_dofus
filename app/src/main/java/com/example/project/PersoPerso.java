package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.project.appclasses.Personnage;
import com.example.project.database_dofusm.DofusMDBHandler;

public class PersoPerso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perso_perso);
    }

    public void loadStudents(View view) {
        DofusMDBHandler dbHandler = new DofusMDBHandler(this, null, null, 1);
        lst.setText(dbHandler.loadHanler());
        studentid.setText("");
        studentname.setText("");
    }

    public void addPerso(View view) {
        DofusMDBHandler dbHandler = new DofusMDBHandler(this, null, null, 1);
        int id = Integer.parseInt(idClasse.getText().toString());
        String name = nomClasse.getText().toString();
        Personnage perso = new Perso(id, name);*/
        dbHandler.addPer(student);
        idClasse.setText("");
        studentname.setText("");

    }
}
