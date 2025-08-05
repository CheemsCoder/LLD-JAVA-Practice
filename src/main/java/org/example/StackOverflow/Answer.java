package org.example.StackOverflow;

public class Answer {
    Question question;
    Integer id;
    User user;
    String content;

    public Answer(Question question, Integer id, User user, String content) {
        this.question = question;
        this.id = id;
        this.user = user;
        this.content = content;
    }

    public String printAnswer() {
        String as = "Id: " + id + " Content: " + content + "\n";
        return as;
    }
}
