package com.chigov.firebase_chat;

public class Message {
    private String author;
    private String messageText;

    //constructor with parameters
    public Message(String author, String messageText) {
        this.author = author;
        this.messageText = messageText;
    }
    //constructor with no parameters
    public Message() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
