package ru.endrysan.java.task_tracker_client.services;

import ru.endrysan.java.task_tracker_client.Client;
import ru.endrysan.java.task_tracker_client.model.User;

public class SocketService {
    
    public SocketService(User user) {
        new Client(user);
    }
    
}
