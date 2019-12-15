package com.example.project.persotrans;

import android.util.Log;

import com.example.project.appclasses.Personnage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ObjSend {

    private static String TAG = "tag";
    private Socket mmSocket;
    private ObjectInputStream mmInStream;


    //mmSocket is the socket i got from a bluetooth connection
    //this is for sending an object
    public void writeSerialized(Personnage pers) {
        Object p = new Personnage(pers);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(mmSocket.getOutputStream());
            oos.writeObject(p);
            oos.close();
        } catch (Exception e) {
            Log.e(TAG, "Error ObjectOutputStream: " + e.getLocalizedMessage());
        }

    }

    //mmInputStream is Stream I got from socket. This is for receiving side
    public void run() {
        // Keep listening to the InputStream while connected
        while (true) {

            try {

                ObjectInputStream ois = new ObjectInputStream(mmInStream);
                Object contact = ois.readObject();
                Log.i(TAG, "Contact class: " + contact);

            } catch (IOException | ClassNotFoundException e) {
                Log.i("ERROR", "E:" + e.getLocalizedMessage());
            }
        }
    }


}
