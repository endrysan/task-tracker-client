package ru.endrysan.java.task_tracker_client.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import ru.endrysan.java.task_tracker_client.Client;

public class WorkplaceView extends JFrame implements View {

    public WorkplaceView(final Client c) {
        super("Workplace");
        setPreferredSize(new Dimension(200, 100));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        setLayout(new FlowLayout());
        JButton button = new JButton("Logout");
        button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                c.logout(null);
                dispose();
                new MainView();
            }
        });
        add(button);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
