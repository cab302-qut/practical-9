package com.example.javafxthread.exercise2;
import com.example.javafxthread.exercise2.dummyjson.*;
import javafx.scene.control.ListView;

/**
 * Manages the list of remote users.
 * Provides methods to search for users and clear the list.
 */
public class RemoteUsersManager {
    private final ListView<User> remoteListView;
    /**
     * Constructs a new RemoteUsersManager with the specified ListView.
     *
     * @param remoteListView the ListView to display the remote users
     */
    public RemoteUsersManager(ListView<User> remoteListView) {
        this.remoteListView = remoteListView;
    }
    /**
     * Returns an array of mock User objects.
     * This is a placeholder for actual remote user data.
     *
     * @return an array of mock User objects
     */
    private User[] getMockUsers() {
        return new User[]{
            new User("John", "Doe", "john.doe@example.com"),
            new User("Jane", "Doe", "jane.doe@example.com"),
            new User("Alice", "Smith", "alice.smith@example.com"),
            new User("Bob", "Johnson", "bob.johnson@example.com"),
            new User("Charlie", "Brown", "charlie.brown@example.com")
        };
    }
    /**
     * Searches for users based on the specified search string.
     * The search results are added to the remoteListView.
     *
     * @param search the search string
     */
    public void searchUsers(String search) {
        // TODO: Replace this mock implementation with actual search logic on a remote API
        // 1. Create a new Fetcher<Users>(Users.class) object
        // 2. Construct the URL "https://dummyjson.com/users/search?q=" + search as a String
        // 3. Call fetcher.get(url), which returns a Users object, which has a .users() method that returns an array of User objects
        // 4. You may run the application and test the search functionality
        //    but will find that clicking on the search button freezes the UI
        // 5. Wrap all the code in this method in a new Thread
        // 6. Start the thread
        User[] users = getMockUsers();
        clearUsers();
        remoteListView.getItems().addAll(users);
    }
    /**
     * Clears the list of remote users.
     * All users are removed from the remoteListView.
     */
    public void clearUsers() {
        remoteListView.getItems().clear();
    }
}
