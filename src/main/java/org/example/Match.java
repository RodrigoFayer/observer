package org.example;

import java.util.Observable;

public class Match extends Observable {
    private String homeTeam;
    private String awayTeam;
    private int homeScore = 0;
    private int awayScore = 0;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void setScore(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        setChanged();
        notifyObservers(this);
    }

    public void markHomeGoal() {
        this.homeScore++;
        setChanged();
        notifyObservers(this);
    }

    public void markAwayGoal() {
        this.awayScore++;
        setChanged();
        notifyObservers(this);
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    @Override
    public String toString() {
        return this.homeTeam + " " + this.homeScore + " - " + this.awayScore + " " + this.awayTeam;
    }
}
