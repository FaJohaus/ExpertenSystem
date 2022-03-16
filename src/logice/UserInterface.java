package logice;

import java.util.Scanner;

import utils.utils;

public class UserInterface {

    Scanner in;
    Questions qs;

    public UserInterface(Questions qs) {
        this.qs = qs;

        in = new Scanner(System.in);
    }

    public void Useraction() {

        System.out.println(qs.getQuestions());

        while (true) {

            String userin = in.nextLine();

            Boolean answer = utils.trueOrfalse(userin);

            if (answer == null) {
                System.out.println("Das ist keine gültige Antwort");
                continue;
            }
            qs.submitAnswer(answer);

            String ques = qs.getQuestions();

            if (ques == null && answer) {

                return;

            } else if (ques == null && !answer) {
                break;
            }

            System.out.println(ques);

        }

        System.out.println(
                "Bitte schreibe eine Frage in die Console die mit ja  Beatwortet werden kann und dein Tier beschreibt.");

        System.out.println("Frage:");
        String frage = in.nextLine();
        System.out.print("Tier:");
        String tier = in.nextLine();

        qs.setQuestion(frage, tier);

    }

}
