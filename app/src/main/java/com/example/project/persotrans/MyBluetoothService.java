package com.example.project.persotrans;

import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.project.appclasses.Personnage;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyBluetoothService {
    private static final String TAG = "MY_APP_DEBUG_TAG";
    private Handler handler;


    private class ConnectedThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket) {
            mmSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the input and output streams; using temp objects because
            // member streams are final.
            try {
                tmpIn = socket.getInputStream();
            } catch (IOException e) {
                Log.e(TAG, "Error occurred when creating input stream", e);
            }
            try {
                tmpOut = socket.getOutputStream();
            } catch (IOException e) {
                Log.e(TAG, "Error occurred when creating output stream", e);
            }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            // Keep listening to the InputStream while connected
            while (true) {

                try {

                    ObjectInputStream ois = new ObjectInputStream(mmInStream);
                    Object Personnage = ois.readObject();
                    Log.i(TAG, "Contact class: " + Personnage);

                } catch (IOException | ClassNotFoundException e) {
                    Log.i("ERROR", "E:" + e.getLocalizedMessage());
                }
            }
        }


        // Call this from the main activity to send data to the remote device.
        public void writeSerialized(Personnage pers) {
            Object p = new Personnage(pers);
            try {
                ObjectOutputStream oos = new ObjectOutputStream(mmOutStream);
                oos.writeObject(p);
                oos.close();
            } catch (Exception e) {
                Log.e(TAG, "Error ObjectOutputStream: " + e.getLocalizedMessage());
            }

        }

        // Call this method from the main activity to shut down the connection.
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "Could not close the connect socket", e);
            }
        }
    }
}