import logice.UserInterface;
import utils.BinBaum;
import logice.*;

public class App {
    public static void main(String[] args) throws Exception {

        BinBaum bb = new BinBaum();

        Questions qs;
        UserInterface ui;
        while (true) {
            qs = new Questions(bb);
            ui = new UserInterface(qs);
            System.out.println("-----------");
            bb.debug();
            System.out.println("-----------");

            System.out.println("Neuer Nutzer:");
            ui.Useraction();

        }
    }
}
