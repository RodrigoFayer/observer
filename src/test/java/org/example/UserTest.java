package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldNotifyUser() {
        Match match = new Match("Home", "Away");
        User user = new User("User");

        user.alert(match);
        match.markHomeGoal();

        assertEquals("User received the notification: Home 1 - 0 Away", user.getLastScoreNotification());
    }

    @Test
    void shouldNotifyUsers() {
        Match match = new Match("Home", "Away");
        User user1 = new User("User1");
        User user2 = new User("User2");

        user1.alert(match);
        user2.alert(match);
        match.markHomeGoal();

        assertEquals("User1 received the notification: Home 1 - 0 Away", user1.getLastScoreNotification());
        assertEquals("User2 received the notification: Home 1 - 0 Away", user2.getLastScoreNotification());
    }

    @Test
    void shouldNotNotifyUser() {
        Match match = new Match("Home", "Away");
        User user = new User("User");

        match.markHomeGoal();

        assertNull(user.getLastScoreNotification());
    }

    @Test
    void shouldNotifyOnlyOneUser() {
        Match match1 = new Match("Home", "Away");
        Match match2 = new Match("Home2", "Away2");
        User user1 = new User("User1");
        User user2 = new User("User2");

        user1.alert(match1);
        user2.alert(match2);
        match1.markHomeGoal();

        assertEquals("User1 received the notification: Home 1 - 0 Away", user1.getLastScoreNotification());
        assertNull(user2.getLastScoreNotification());
    }
}