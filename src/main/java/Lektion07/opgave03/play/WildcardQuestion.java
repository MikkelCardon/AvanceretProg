package Lektion07.opgave03.play;

import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

public class WildcardQuestion extends Question {
    private String question;
    private String correctAnswer;

    public WildcardQuestion(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer.toLowerCase();
    }


    @Override
    protected void displayQuestion() {
        System.out.println("Question: "+question);
    }

    @Override
    protected String getUserAnswer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write your answer: ");
        return scan.nextLine();
    }

    @Override
    protected boolean checkAnswer(String answer) {
        return correctAnswer.equals(answer.toLowerCase());
    }
}
