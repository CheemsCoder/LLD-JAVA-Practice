package org.example.StackOverflow;

public class Comment {
    Integer id;
    String content;
    User commentedBy;
    public Comment(Integer id, String content, User commentedBy) {
        this.id = id;
        this.content = content;
        this.commentedBy = commentedBy;
    }
}
