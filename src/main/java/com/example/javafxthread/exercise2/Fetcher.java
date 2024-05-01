package com.example.javafxthread.exercise2;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Fetcher is a generic class that fetches data from a given URL and deserializes it into an object of type T.
 *
 * @param <T> the type of the object to deserialize the response into
 */
public class Fetcher<T> {
    private Class<T> clazz;
    private HttpClient client = HttpClient.newHttpClient();

    /**
     * Constructs a new Fetcher with the given class type, ideally a record.
     * If the class type is not a record, it fields must be public.
     *
     * @param clazz the class type to deserialize the response into
     */
    public Fetcher(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Sends a GET request to the given URL and returns the response as an object of type T.
     * Example usage:
     * Fetcher<Users> fetcher = new Fetcher<>(Users.class);
     *
     * @param url the URL to send the GET request to
     * @return the response as an object of type T
     */
    public T get(String url) {
        // Create a new HTTP request with the given URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            // Send the HTTP request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Create a new Gson object to deserialize the response
            Gson gson = new Gson();
            return gson.fromJson(response.body(), clazz);
        } catch (Exception e) {
            // Print the stack trace and return null if an exception occurs
            e.printStackTrace();
            return null;
        }
    }
}