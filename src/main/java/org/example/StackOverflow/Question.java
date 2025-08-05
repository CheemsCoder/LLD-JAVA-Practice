package org.example.StackOverflow;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Question {
    Integer id;
    String title;
    String description;
    Map<Integer, List<Comment>> comments;
    User creator;
    Map<Integer, List<Answer>> answers;


    public Question(Integer id, String title, String description, User creator) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.comments = new HashMap<>();
        this.answers = new HashMap<>();
    }

    public void addComment(User user, Comment comment) {
        if(!comments.containsKey(user.id)) {
            List<Comment> cts = new ArrayList<>();
            comments.put(user.id, cts);
        }
        comments.get(user.id).add(comment);
    }

    public void addAnswer(User user, Answer answer) {
        if(!answers.containsKey(user.id)) {
            List<Answer> a = new ArrayList<>();
            answers.put(user.id, a);
        }
        answers.get(user.id).add(answer);
    }

    public String printQuestion() {
        String sb = "Id: " + id + "\n";
        sb += "Title: " + title + "\n";
        sb += "Description: " + description + "\n";
        sb+= "Creator: " + creator.id + "\n";
        sb+= "Answers:\n";
        for(Map.Entry<Integer, List<Answer>> entry : answers.entrySet()) {
            Integer userId = entry.getKey();
            List<Answer> answers = entry.getValue();
            sb+= "Customer: " + userId + "\n";
            for(Answer a : answers) {
                sb+= a.printAnswer();
            }

        }
        return sb;
    }

}
