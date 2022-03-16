package logice;

import java.util.ArrayList;
import utils.BinBaum;

public class Questions {

    private ArrayList<Boolean> path = new ArrayList<Boolean>();
    private BinBaum bb = new BinBaum();

    public void submitAnswer(boolean answer) {

        path.add(answer);

    };

    public String getQuestions() {

        return bb.get(path);

    }

    public void setQuestion(String question) {
    };

}
