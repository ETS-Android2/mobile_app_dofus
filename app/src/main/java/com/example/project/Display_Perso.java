package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.project.appclasses.Personnage;
import com.example.project.database_dofusm.DofusMDBHandler;

import java.util.List;
import java.util.Set;

public class Display_Perso extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    private TextView dis;
    private Personnage p;
    private DofusMDBHandler dbHandler;
    private String _id;
    public static final int REQUEST_ENABLE_BT=1;

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
        setContentView(R.layout.activity_display__perso);
        Intent inte = getIntent();
        _id = inte.getStringExtra("id_perso");
        dis = (TextView) findViewById(R.id.textView5);
        dis.setText(showPerso(Integer.parseInt(_id)));
    }

    public String showPerso(int id){
        DofusMDBHandler dbHandler = new DofusMDBHandler(this);
        p = dbHandler.findPersoHandler(Integer.toString(id));
        refreshScreen();
        String pers = p.toString();
        return pers;
    }

    public void delPerso(View view){
        int why = Integer.parseInt(_id);;
        dbHandler.deletePersoHandler(why);
        Intent myIntent = new Intent(this, MyPerso.class);
        startActivity(myIntent);
    }

    public void editPerso(View view){
        Intent myIntent = new Intent(this, CreatePerso.class);
        myIntent.putExtra("id_perso", _id);
        startActivity(myIntent);
    }

    public void sendP(View view) {
        BluetoothAdapter ada = BluetoothAdapter.getDefaultAdapter();
        if (ada != null ){
            if (!ada.isEnabled()) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
            Set<BluetoothDevice> pairedDevices = ada.getBondedDevices();

            if (pairedDevices.size() > 0) {
                // There are paired devices. Get the name and address of each paired device.
                for (BluetoothDevice device : pairedDevices) {
                    String deviceName = device.getName();
                    String deviceHardwareAddress = device.getAddress(); // MAC address
                }
            }
        }
    }

    public void refreshScreen(){
        dis.setText("");
    }


}
