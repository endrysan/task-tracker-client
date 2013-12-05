package ru.endrysan.java.task_tracker_client.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ru.endrysan.java.task_tracker_client.controller.WorkplaceController;

public class WorkplaceView extends JFrame implements View {
    
    public JButton buttonStartWork;
    public JButton buttonEndWork;
    public JButton buttonStandDown;
    public JButton buttonLogOut;
    public JLabel labelNotification;
    
    public WorkplaceView() {
        
        super("Workplace");
        setPreferredSize(new Dimension(300, 200));
        setResizable(false);
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        JPanel panelNotification = new JPanel();
        panelNotification.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        labelNotification = new JLabel("");
        panelNotification.add(labelNotification);
        
        JPanel panelButtonWork = new JPanel(new GridLayout(2, 2, 5, 10));
        buttonStartWork = new JButton("Start Work");
        buttonEndWork = new JButton("End Work");
        buttonStandDown = new JButton("Stand Down");
        buttonLogOut = new JButton("Log Out");
        
        panelButtonWork.add(buttonStartWork);
        panelButtonWork.add(buttonEndWork);
        panelButtonWork.add(buttonStandDown);
        panelButtonWork.add(buttonLogOut);
        
        add(panelNotification);
        add(panelButtonWork);
        
        WorkplaceController workplaceController = new WorkplaceController(this);
        buttonStartWork.addActionListener(workplaceController);
        buttonEndWork.addActionListener(workplaceController);
        buttonStandDown.addActionListener(workplaceController);
        buttonLogOut.addActionListener(workplaceController);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
