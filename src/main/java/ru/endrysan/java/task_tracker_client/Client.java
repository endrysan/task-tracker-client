package ru.endrysan.java.task_tracker_client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.io.IOUtils;

import ru.endrysan.java.task_tracker_client.model.User;

public class Client {
    
    private final static int PORT = 3078;
    private static Socket socket;
    public boolean isUser = false;
    
    public Client() {
        try {
            socket = new Socket("127.0.0.1", PORT);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Client(User newUser) {
        BufferedOutputStream out = null;
        ObjectOutputStream oot = null;
        
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;
        try{
            if (socket == null) {
                socket = new Socket("127.0.0.1", PORT);
            }
            out = new BufferedOutputStream(socket.getOutputStream());
            oot = new ObjectOutputStream(out);
            oot.writeObject(newUser);
            
            bis = new BufferedInputStream(socket.getInputStream());
            ois = new ObjectInputStream(bis);
            isUser = (Boolean)ois.readObject();
            
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(oot);
        }
    }
    
}
