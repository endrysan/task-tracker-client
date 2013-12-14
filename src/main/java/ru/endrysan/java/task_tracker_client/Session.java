package ru.endrysan.java.task_tracker_client;

import java.util.Date;

import ru.endrysan.java.task_tracker_client.model.User;

public class Session {

    private User user;
    private Date startDate;
    private Date endDate;

    public Session(User user) {
        this.user = user;
        startDate = new Date();
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public Date getStartDate() {
        return startDate;
    }

}
