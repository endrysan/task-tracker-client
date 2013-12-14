package ru.endrysan.java.task_tracker_client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.endrysan.java.task_tracker_client.Client;
import ru.endrysan.java.task_tracker_client.ServerAnswer;
import ru.endrysan.java.task_tracker_client.ServerAnswer.Type;
import ru.endrysan.java.task_tracker_client.model.User;
import ru.endrysan.java.task_tracker_client.view.MainView;
import ru.endrysan.java.task_tracker_client.view.WorkplaceView;

public class MainController implements ActionListener {
    
    private Client client = new Client();
    public MainView parentMainView;
    
    public MainController(MainView parentMainView) {
        this.parentMainView = parentMainView;
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == parentMainView.buttonLogIn) {
            onLogIn(e);
        }
        if (e.getSource() == parentMainView.buttonSignUp) {
            onAddUser(e); 
        }
        if (e.getSource() == parentMainView.buttonCancel) {
            parentMainView.setVisible(false);
            parentMainView.dispose();
        }
    }
    
    private void onLogIn(ActionEvent e) {
        String displayFieldTextLogin = parentMainView.fieldLogin.getText();
        char[] displayFieldTextPassword = parentMainView.fieldPassword.getPassword();
        
        User newUser = new User();
        
        newUser.setLogin(displayFieldTextLogin);
        newUser.setPassword(new String(displayFieldTextPassword));
        
        ServerAnswer serverAnswer = client.login(newUser);
        if (Type.SUCCESS.equals(serverAnswer.getType())) {
            parentMainView.labelNotification.setText("");
            parentMainView.setVisible(false);
            new WorkplaceView(client);
        } else {
            parentMainView.labelNotification.setText(serverAnswer.getMessage()); 
        }
    }

    private void onAddUser(ActionEvent e) {
        String displayFieldTextLogin = parentMainView.fieldLogin.getText();
        char[] displayFieldTextPassword = parentMainView.fieldPassword.getPassword();
        
        User newUser = new User();
        
        newUser.setLogin(displayFieldTextLogin);
        newUser.setPassword(new String(displayFieldTextPassword));
        
        ServerAnswer serverAnswer = client.register(newUser);
        if (Type.SUCCESS.equals(serverAnswer.getType())) {
            parentMainView.labelNotification.setText("");
            parentMainView.setVisible(false);
            new WorkplaceView(client);
        } else {
            parentMainView.labelNotification.setText(serverAnswer.getMessage()); 
        }
    }
    
}
