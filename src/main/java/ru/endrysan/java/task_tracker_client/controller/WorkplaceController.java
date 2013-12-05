package ru.endrysan.java.task_tracker_client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.endrysan.java.task_tracker_client.model.User;
import ru.endrysan.java.task_tracker_client.view.MainView;
import ru.endrysan.java.task_tracker_client.view.WorkplaceView;

public class WorkplaceController implements ActionListener {

    public WorkplaceView parentWorkplaceView;
    
    public WorkplaceController(WorkplaceView parentWorkplaceView) {
        this.parentWorkplaceView = parentWorkplaceView;
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == parentWorkplaceView.buttonStartWork) {
            onStartWork(e);
        }
        if (e.getSource() == parentWorkplaceView.buttonEndWork) {
            onEndWork(e); 
        }
        if (e.getSource() == parentWorkplaceView.buttonStandDown) {
            parentWorkplaceView.setVisible(false);
            parentWorkplaceView.dispose();
        }
        if (e.getSource() == parentWorkplaceView.buttonLogOut) {
            parentWorkplaceView.setVisible(false);
            parentWorkplaceView.dispose();
            new MainView();
        }
    }
    
    private void onStartWork(ActionEvent e) {
        
    }

    private void onEndWork(ActionEvent e) {
        
    }
}
