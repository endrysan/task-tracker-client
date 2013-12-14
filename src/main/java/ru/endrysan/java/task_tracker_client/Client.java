package ru.endrysan.java.task_tracker_client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import ru.endrysan.java.task_tracker_client.ServerCommand.Action;
import ru.endrysan.java.task_tracker_client.model.User;

public class Client {
    
    private static final int PORT = 3078;
    private static final Logger LOG = Logger.getLogger(Client.class);

    private Socket socket;
    private BufferedOutputStream out;
    private ObjectOutputStream oot;
    
    private BufferedInputStream bis;
    private ObjectInputStream ois;

    private ServerAnswer sendCommand(ServerCommand command) {
        try {
            if (socket == null && !Action.SIGNOUT.equals(command.getAction())) {
                socket = new Socket("127.0.0.1", PORT);
                out = new BufferedOutputStream(socket.getOutputStream());
                oot = new ObjectOutputStream(out);
            }
            oot.writeObject(command);
            oot.flush();

            if (bis == null && ois == null) {
                bis = new BufferedInputStream(socket.getInputStream());
                ois = new ObjectInputStream(bis);
            }
            return (ServerAnswer) ois.readObject();
        } catch (Exception e){
            LOG.error("", e);
        }
        return null;
    }

    public ServerAnswer login(User user) {
        return sendCommand(new ServerCommand(Action.SIGNIN, user));
    }

    public ServerAnswer register(User user) {
        return sendCommand(new ServerCommand(Action.SIGNUP, user));
    }

    public ServerAnswer logout(User user) {
        ServerAnswer result = sendCommand(new ServerCommand(Action.SIGNOUT, user));
        IOUtils.closeQuietly(oot);
        IOUtils.closeQuietly(ois);
        IOUtils.closeQuietly(socket);
        oot = null;
        out = null;
        socket = null;
        bis = null;
        ois = null;
        return result;
    }
}
