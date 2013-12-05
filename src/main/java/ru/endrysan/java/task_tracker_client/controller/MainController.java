package ru.endrysan.java.task_tracker_client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.endrysan.java.task_tracker_client.Client;
import ru.endrysan.java.task_tracker_client.model.User;
import ru.endrysan.java.task_tracker_client.services.SocketService;
import ru.endrysan.java.task_tracker_client.view.MainView;

public class MainController implements ActionListener {
    
    private SocketService service;
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
        
        service = new SocketService(newUser);
        
        parentMainView.setVisible(false);
    }

    private void onAddUser(ActionEvent e) {
        String displayFieldTextLogin = parentMainView.fieldLogin.getText();
        char[] displayFieldTextPassword = parentMainView.fieldPassword.getPassword();
        
        User newUser = new User();
        
        newUser.setLogin(displayFieldTextLogin);
        newUser.setPassword(new String(displayFieldTextPassword));
        
        service = new SocketService(newUser);
        
        parentMainView.setVisible(false);
    }
    
}
