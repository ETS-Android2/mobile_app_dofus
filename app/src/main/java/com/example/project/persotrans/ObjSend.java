/*package com.example.project.persotrans;

import android.util.Log;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjSend {

    private static String TAG = "tag";

    //mmSocket is the socket i got from a bluetooth connection
    //this is for sending an object
    public void writeSerialized() {
        Object contact = new Contact("Allen", "Patterson", "256-369-241");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(mmSocket.getOutputStream());
            oos.writeObject(contact);
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

    //the object I am trying to send out and receive on the other size

    public class Contact implements Serializable {

        static final long serialVersionUID = 123456789123456789L;

        private String id;
        private String name;
        private String phoneNumber;

        public Contact() {
        }

        public Contact(String id, String name, String phoneNumber) {
            this.id = id;
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }


    }

}
*/