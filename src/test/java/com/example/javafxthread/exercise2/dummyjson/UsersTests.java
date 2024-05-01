package com.example.javafxthread.exercise2.dummyjson;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsersTests {
    @Test
    public void testUsersEmpty() {
        Users users = new Users(new User[]{});
        assertTrue(users.users().length == 0);
    }

    @Test
    public void testUsersOneUser() {
        User user = new User("John", "Doe", "john.doe@example.com");
        Users users = new Users(new User[]{user});
        assertEquals(1, users.users().length);
        assertEquals(user, users.users()[0]);
    }

    @Test
    public void testUsersMultipleUsers() {
        User user1 = new User("John", "Doe", "john.doe@example.com");
        User user2 = new User("Jane", "Doe", "jane.doe@example.com");
        Users users = new Users(new User[]{user1, user2});
        assertEquals(2, users.users().length);
        assertEquals(user1, users.users()[0]);
        assertEquals(user2, users.users()[1]);
    }

    @Test
    public void testUsersEquality() {
        User user = new User("John", "Doe", "john.doe@example.com");
        Users users1 = new Users(new User[]{user});
        Users users2 = new Users(new User[]{user});
        assertEquals(users1, users2);
    }

    @Test
    public void testUsersInequality() {
        User user1 = new User("John", "Doe", "john.doe@example.com");
        User user2 = new User("Jane", "Doe", "jane.doe@example.com");
        Users users1 = new Users(new User[]{user1});
        Users users2 = new Users(new User[]{user2});
        assertNotEquals(users1, users2);
    }
}