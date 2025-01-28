package com.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private String[] options;
    private String correctAnswer;
    public Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
class User {
    private String name;
    private int score;
    public User(String name) {
        this.name = name;
        this.score = 0;
    }
    public void updateScore(boolean correct) {
        if (correct) {
            score++;
        }
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
}
class Quiz {
    private List<Question> questions;
    public Quiz() {
        this.questions = new ArrayList<>();
    }
    public void addQuestion(Question question) {
        questions.add(question);
    }
    public void takeQuiz(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting quiz for " + user.getName() + "\n");
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            System.out.print("Enter your answer (1-" + options.length + "): ");
            int answer = scanner.nextInt();
            scanner.nextLine();  
            if (options[answer - 1].equalsIgnoreCase(question.getCorrectAnswer())) {
                System.out.println("Correct!");
                user.updateScore(true);
            } else {
                System.out.println("Incorrect! The correct answer was: " + question.getCorrectAnswer());
            }
            System.out.println();
        }

        System.out.println("Quiz finished! Your score: " + user.getScore() + "/" + questions.size());
    }
}
public class OnlineQuiz {

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        String[] options1 = {"Java", "C", "Python", "Ruby"};
        Question question1 = new Question("Which programming language is this quiz written in?", options1, "Java");

        String[] options2 = {"Chennai", "Hyderabad", "Amaravathi", "Mumbai"};
        Question question2 = new Question("What is the capital of Andhra Pradesh?", options2, "Amaravathi");

        String[] options3 = {"230", "200", "270", "250"};
        Question question3 = new Question("What is 50 * 5?", options3, "250");

        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        User user = new User(name);
        quiz.takeQuiz(user);
    }
}

