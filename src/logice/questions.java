package logice;

import java.util.ArrayList;
import utils.BinBaum;

public abstract class questions {

    private ArrayList<Boolean> questions = new ArrayList<Boolean>();
    private BinBaum bb = new BinBaum();

    abstract String question(String question);

}
