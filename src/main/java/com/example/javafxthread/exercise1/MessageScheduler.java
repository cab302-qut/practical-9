package com.example.javafxthread.exercise1;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * This class is responsible for scheduling messages.
 * It uses a TextArea to display the history of messages.
 */
public class MessageScheduler {
    @FXML
    private TextArea historyTextArea;

    /**
     * Constructs a new MessageScheduler with the specified TextArea.
     *
     * @param historyTextArea the TextArea to display the history of messages
     */
    public MessageScheduler(TextArea historyTextArea) {
        this.historyTextArea = historyTextArea;
    }

    /**
     * Schedules a message to be displayed after a specified delay.
     * The message is appended to the historyTextArea.
     *
     * @param message the message to be displayed
     * @param delay the delay (in seconds) before the message is displayed
     */
    public void scheduleMessage(String message, int delay) {
        // TODO: Modify this method to:
        // 1. Create a new Thread
        // 2. In a try block, call Thread.sleep(delay * 1000) to sleep the thread for the specified delay.
        // 3. In a catch block, if an InterruptedException is thrown, throw a new RuntimeException with the caught exception as the cause
        // 4. Call historyTextArea.appendText(message + "\n") to append the message to the text area
        // 5. Start the thread
        historyTextArea.appendText(message + "\n");
    }
}