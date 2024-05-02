package com.example.javafxthread.exercise2.dummyjson;

import java.util.Arrays;

// TODO: Convert this class to a record
// To ensure its correctness, find and run the UsersTests class in the test/java directory
public final class Users {
    private final User[] users;
    public Users(User[] users) {
        this.users = users;
    }
    public User[] users() {
        return users;
    }
    @Override
    public String toString() {
        return "Users{" +
                "users=" + Arrays.toString(users) +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return java.util.Arrays.equals(users, users1.users);
    }
    @Override
    public int hashCode() {
        return java.util.Arrays.hashCode(users);
    }
}