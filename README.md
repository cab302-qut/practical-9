---
name: "Activity 10.3 - Practical: Threads and REST API in JafaFX"
---
The practical activities prepared for this week are listed below. We recommend you attempt, or at least read through some of them before coming to class. This will help you to get the most out of the practical sessions.

Depending on the kinds of issues of concern each week, as well as the overall progress of the class, the tutor may choose to focus on some of the practical activities more than others. While this is at the tutor's discretion, if time permits, you are welcome to request that the tutor cover a particular activity in more detail if you feel it would be beneficial.

Don't be afraid to ask questions in class if you get stuck, or even if you just want to know more about something - other students in the class will probably have the same question but are too shy to ask!

---

# Practical 10 - Threads and REST API in JafaFX

Before we begin, you will need to clone the repository from https://github.com/cab302-qut/threads-prac.

```
git clone https://github.com/qut-cab302/prac11.git
```

## Introduction

In this practical, you will learn how to use `Thread` and REST API in JavaFX. There are two exercises in this practical, which are embedded in a single JavaFX application for simplicity.

- **Exercise 1 - Scheduled Messages**: Messages are displayed on the screen after a selected delay.
- **Exercise 2 - REST API**: Fetch data from a REST API and display it in a `ListView`.

Most of the code is already provided, and you will need to complete the missing parts to make the application work as expected.

The UI and the controller classes are already **fully implemented**. You may run the application as soon as you clone the repository, although it does not provide the expected functionality yet.

## Exercise 1 - Scheduled Messages

---

The code for this exercise can be found in the `excercise1` package, which includes a single `MessageScheduler` class. The `scheduleMessage(String message, int delay)` method is called by the `onSendButtonClicked()` method in the `MainController` class, which is triggered when the "Send" button is clicked.

> [!IMPORTANT]
> 
> **Your Task**
> 
> Currently, the `scheduleMessage(String message, int delay)` method displays the message immediately, without any delay.
> You need to modify this method to display the message after the specified delay, following the suggestions in the comments.
> ```java
> public void scheduleMessage(String message, int delay) {
>     // TODO: Modify this method to:
>     // 1. Create a new Thread
>     // 2. In a try block, call Thread.sleep(delay * 1000) to sleep the thread for the specified delay.
>     // 3. In a catch block, if an InterruptedException is thrown, throw a new RuntimeException with the caught exception as the cause
>     // 4. Call historyTextArea.appendText(message + "\n") to append the message to the text area
>     // 5. Start the thread
>     historyTextArea.appendText(message + "\n");
> }

<details>
<summary>Hints: Creating and starting a new thread (click to expand)</summary>

A `Thread` object is created by passing a `Runnable` object to its constructor.

The `Runnable` object is an interface that represents a task that can be executed by a thread. The `Runnable` interface has a single method, `run()`, which is called when the thread is started.

```java
// Anonymous class implementing the Runnable interface
Runnable task = new Runnable() {
    @Override
    public void run() {
        // Your task here, 
        // like waiting for a 1 second (1000 milliseconds)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1 second has passed since the thread started.");
    }
};
// Create and start a new thread to execute the task
Thread thread = new Thread(task);
thread.start();
```

You may also use a **lambda expression** to create a `Runnable` object, which is more concise but may be less readable for beginners.

```java
Runnable task = () -> {
    // Your task here
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("1 second has passed since the thread started.");
};
```

</details>

## Exercise 2 - Accessing a REST API

---

The code for this exercise can be found in the `excercise2` package, which contains a provided `Fetcher` class, and a `RemoteUsersManager`. Additionally, there is a `dummyjson` package containing 
- A `User` class (with `firstName`, `lastName`, and `email` fields) and 
- A `Users` class (with a `User[] users` field).

> [!IMPORTANT]
> 
> **Your Task**
> 
> Currently, clicking the "Search" button in the application displays a list of mock users.
>
> Your task is to complete the `searchUsers(String search)` method in the `RemoteUsersManager` class. This method should get data from the `https://dummyjson.com/users/search?q={search}` REST API, and return a `Users` object containing the users found. You may follow the instructions in the comments.
>
> ```java
> public void searchUsers(String search) {
>     // TODO: Replace this mock implementation with actual search logic on a remote API
>     // 1. Create a new Fetcher<Users>(Users.class) object
>     // 2. Construct the URL "https://dummyjson.com/users/search?q=" + search as a String
>     // 3. Call fetcher.get(url), which returns a Users object, which has a .users() method that returns an array of User objects
>     // 4. You may run the application and test the search functionality
>     //    but will find that clicking on the search button freezes the UI
>     // 5. Wrap all the code in this method in a new Thread
>     // 6. Start the thread
>     User[] users = getMockUsers();
>     clearUsers();
>     remoteListView.getItems().addAll(users);
> }
> ```
> Visit [this](https://dummyjson.com/users/search?q=john) to see the JSON response you should expect when searching for users with the name "john".
>
> To help you with this task, a `Fetcher` class is provided, which you can use to get data from a url:
>
> ```java
> String url = "https://dummyjson.com/users/search?q=john";
> Fetcher<Users> fetcher = new Fetcher<>(Users.class);
> User[] users = fetcher.get(url).users();
> ```
> Additionally, you may want to **convert the `User` and `Users` classes to records** to avoid a runtime error when parsing the JSON response. See the hint below for more information.

<details>
<summary>Hint: Convert data classes to records (click to expand)</summary>

If you add the above code to the `searchUsers(String search)` method, you will get a runtime error where Gson has trouble converting accessing the `users` field in the JSON response:

```plaintext
com.google.gson.JsonIOException: Failed making field 'com.example.javafxthread.exercise2.dummyjson.Users#users' accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.
```

While this can be fixed by either making the `users` field public (which is a bad practice), or writing a custom [`TypeAdapter`](https://www.tutorialspoint.com/gson/gson_custom_adapters.htm), which is a bit more complex than necessary for this exercise. There is a simpler and more elegant solution: **convert the `User` and `Users` classes to records**.

A **record** is a special kind of class introduced in Java 14 that is designed to be a simple and concise way to define classes that are mostly data. Records are immutable (so no setters are needed), and they automatically generate `equals()`, `hashCode()`, and `toString()` methods based on the fields defined in the record.

A record is defined using the `record` keyword (instead of `class`), followed by the name of the record and a list of fields in parentheses. For example, a `Rectangle` record with `length` and `width` fields can be defined as follows:

```java
public record Rectangle(double length, double width) { }
```

Which is equivalent to the following class:

```java
public final class Rectangle {
    private final double length;
    private final double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    double length() { return this.length; }
    double width()  { return this.width; }
    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.length, length) == 0 && Double.compare(rectangle.width, width) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }
}
```
</details>