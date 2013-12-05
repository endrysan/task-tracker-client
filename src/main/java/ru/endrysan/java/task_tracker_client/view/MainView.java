package ru.endrysan.java.task_tracker_client.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ru.endrysan.java.task_tracker_client.controller.MainController;

public class MainView extends JFrame implements View {
    
    public JButton buttonLogIn;
    public JButton buttonCancel;
    public JButton buttonSignUp;
    public JTextField fieldLogin;
    public JPasswordField fieldPassword;
    public JLabel labelNotification;
    
    public MainView() {
        
        super("Authorization");
        setPreferredSize(new Dimension(300, 200));
        setResizable(false);
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        JPanel panelFrame = new JPanel(new GridLayout(3, 3, 5, 10));
        
        panelFrame.add(new JLabel("Login"));
        panelFrame.add(fieldLogin = new JTextField(10));
        panelFrame.add(new JLabel("Password"));
        panelFrame.add(fieldPassword = new JPasswordField());
        
        JPanel panelNotification = new JPanel();
        panelNotification.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        labelNotification = new JLabel("");
        panelNotification.add(labelNotification);
        
        buttonLogIn = new JButton("log in");
        buttonCancel = new JButton("cancel");
        buttonSignUp = new JButton("sign up");
        
        JPanel panelButton = new JPanel();
        panelButton.add(buttonLogIn);
        panelButton.add(buttonCancel);
        panelButton.add(buttonSignUp);
        add(panelFrame);
        add(panelNotification);
        add(panelButton);
        
        MainController mainController = new MainController(this);
        buttonLogIn.addActionListener(mainController);
        buttonCancel.addActionListener(mainController);
        buttonSignUp.addActionListener(mainController);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MainView();
    }
}
