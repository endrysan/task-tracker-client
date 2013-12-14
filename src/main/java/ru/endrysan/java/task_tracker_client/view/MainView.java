package ru.endrysan.java.task_tracker_client.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import ru.endrysan.java.task_tracker_client.controller.MainController;

public class MainView extends JFrame implements View {
    
    public JButton buttonLogIn;
    public JButton buttonCancel;
    public JButton buttonSignUp;
    public JTextField fieldLogin;
    public JPasswordField fieldPassword;
    public JTextArea labelNotification;
    
    public MainView() {
        
        super("Authorization");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(300, 300));
        setResizable(false);

        setLayout(new MigLayout("fillx", "left,grow,fill", "[]20[]"));
        add(new JLabel("Login"));
        add(fieldLogin = new JTextField(), "wrap, span 2");
        add(new JLabel("Password"));
        add(fieldPassword = new JPasswordField(), "wrap, span 2");


        labelNotification = new JTextArea("");
        labelNotification.setForeground(Color.RED);
        labelNotification.setLineWrap(true);
        labelNotification.setEditable(false);
        add(labelNotification, "span, wrap, grow");
        
        buttonLogIn = new JButton("log in");
        buttonCancel = new JButton("cancel");
        buttonSignUp = new JButton("sign up");
        
        add(buttonLogIn);
        add(buttonCancel);
        add(buttonSignUp);
        
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
