package com.example.myw;

public class Issue {
    private String title;
    private String id;
    private String severity;
    private String author;
    private String status;
    private String upvotes;
    private String downvotes;
    private String description;

    public Issue(String title,String id ,String severity, String author, String status, String upvotes, String downvotes, String description) {
        this.title = title;
        this.id = id;
        this.severity = severity;
        this.author = author;
        this.status = status;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.description = description;
    }

    // Getters
    public String getTitle() { return title; }
    public String getId() { return id; }
    public String getSeverity() { return severity; }
    public String getAuthor() { return author; }
    public String getStatus() { return status; }
    public String getUpvotes() { return upvotes; }
    public String getDownvotes() { return downvotes; }
    public String getDescription() { return description; }
}
