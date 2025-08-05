package org.example.StackOverflow;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        StackOverflow stackOverflow = StackOverflow.getInstance();
        User u1 = stackOverflow.addUser(1, "u1");
        User u2 = stackOverflow.addUser(2, "u2");
        User u3 = stackOverflow.addUser(3, "u3");

        Question q1 = stackOverflow.addQuestion(u1, 1, "q1", "test1");
        Question q2 = stackOverflow.addQuestion(u1, 2, "q2", "test2");
        Question q3 = stackOverflow.addQuestion(u3, 3, "q3", "test3");

        stackOverflow.addAnswer(u2, q1, 1, "answer u2 in question by u1");
        stackOverflow.addAnswer(u3, q2, 2, "answer u3 in question by u1");
        stackOverflow.addAnswer(u3, q1, 3, "answer u3 in question by u1");
        stackOverflow.addAnswer(u1, q3, 4, "answer u1 in question by u3");

        stackOverflow.showQuestions(u1);
    }
}
