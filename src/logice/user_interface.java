package logice;

import java.util.Scanner;

import utils.utils;

public class user_interface {

    Scanner in = new Scanner(System.in);

    public void Useraction() {
        while (true) {

            String userin = in.nextLine();

            Boolean answer = utils.trueOrfalse(userin);

        }

    }

}
