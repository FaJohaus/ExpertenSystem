package logice;

import java.util.ArrayList;
import utils.BinBaum;

public class Questions {
    private BinBaum bb;
    private ArrayList<Boolean> path = new ArrayList<Boolean>();

    public Questions(BinBaum bb) {
        this.bb = bb;
    }

    public void submitAnswer(boolean answer) {

        path.add(answer);

    };

    public String getQuestions() {

        String a = bb.get(path);
        // System.out.println("Waht: " + path);
        return a;
    }

    public void setQuestion(String question, String tier) {

        bb.add(question, path);
        path.add(true);
        bb.add(String.format("Denkst du an ein %s", tier), path);

    };

}
