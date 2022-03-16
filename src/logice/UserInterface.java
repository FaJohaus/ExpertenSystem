package logice;

import java.util.Scanner;

import utils.utils;

public class UserInterface {

    Scanner in = new Scanner(System.in);
    Questions qs = new Questions();

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

            System.out.println(qs.getQuestions());

        }

    }

}
