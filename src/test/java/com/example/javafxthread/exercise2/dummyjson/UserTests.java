package com.example.javafxthread.exercise2.dummyjson;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserTests {
    @Test
    public void testUserGetters() {
        User user = new User("John", "Doe", "john.doe@example.com");

        assertEquals("John", user.firstName());
        assertEquals("Doe", user.lastName());
        assertEquals("john.doe@example.com", user.email());
    }

    @Test
    public void testUserEquality() {
        User user1 = new User("John", "Doe", "john.doe@example.com");
        User user2 = new User("John", "Doe", "john.doe@example.com");

        assertEquals(user1, user2);
    }

    @Test
    public void testUserDifferentFirstName() {
        User user1 = new User("John", "Doe", "john.doe@example.com");
        User user2 = new User("Jane", "Doe", "john.doe@example.com");
        assertNotEquals(user1, user2);
    }

    @Test
    public void testUserToString() {
        User user = new User("John", "Doe", "john.doe@example.com");
        assertEquals("John Doe (john.doe@example.com)", user.toString());
    }

    @Test
    public void testUserDifferentLastName() {
        User user1 = new User("John", "Doe", "john.doe@example.com");
        User user2 = new User("John", "Smith", "john.doe@example.com");
        assertNotEquals(user1, user2);
    }

    @Test
    public void testUserDifferentEmail() {
        User user1 = new User("John", "Doe", "john.doe@example.com");
        User user2 = new User("John", "Doe", "john.smith@example.com");
        assertNotEquals(user1, user2);
    }
}