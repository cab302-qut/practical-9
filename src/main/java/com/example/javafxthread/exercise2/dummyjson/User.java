package com.example.javafxthread.exercise2.dummyjson;

public record User(String firstName, String lastName, String email) {
    @Override
    public String toString() {
        return firstName() + " " + lastName() + " (" + email() + ")";
    }
}