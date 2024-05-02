package com.example.javafxthread.exercise2.dummyjson;

public record Users(User[] users) {
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