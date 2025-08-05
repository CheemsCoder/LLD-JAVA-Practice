package org.example.StackOverflow;

import java.util.*;

public class StackOverflow {
    private static StackOverflow stackOverflow;
    Map<Integer, User> users;
    Map<Integer, List<Question>> questions;
    private StackOverflow() {
        users = new HashMap<>();
        questions = new HashMap<>();
    }

    public static StackOverflow getInstance() {
        if (stackOverflow == null) {
            stackOverflow = new StackOverflow();
        }
        return stackOverflow;
    }

    public User addUser(Integer id, String name) {
        User user = new User(id, name);
        users.put(id, user);
        if(!questions.containsKey(id)) {
           questions.put(id, new ArrayList<>());
        }
        return user;
    }

    public Question addQuestion(User user, Integer id, String title, String description) {
        Question question = new Question(id, title, description, user);
        questions.get(user.id).add(question);
        return question;
    }

    public void addAnswer(User user, Question question, Integer id, String content) {
        Answer answer = new Answer(question, id, user, content);
        question.addAnswer(user, answer);
    }

    public void showQuestions(User user) {
        for(Question question : questions.get(user.id)) {
            System.out.println(question.printQuestion());
        }
    }
}
