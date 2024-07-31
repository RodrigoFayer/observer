package org.example;

import java.util.Observable;
import java.util.Observer;

public class User implements Observer {
    private String name;
    private String lastScoreNotification;

    public User(String name) {
        this.name = name;
    }

    public String getLastScoreNotification() {
        return lastScoreNotification;
    }

    public void alert(Match match) {
        match.addObserver(this);
    }

    public void update(Observable match, Object arg) {
        this.lastScoreNotification = this.name + " received the notification: " + match.toString();
    }
}
