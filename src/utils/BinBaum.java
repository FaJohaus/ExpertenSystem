package utils;

import java.util.ArrayList;

/**
 * BinBaum
 */
public class BinBaum {

    Node root;

    private boolean checkRoot() {
        if (root == null) {
            return false;
        }
        return true;
    }

    public BinBaum() {
        super();

        root = new Node("Warum?");

    }

    // TODO mal gucken was das wird xd
    public void add(String question, ArrayList<Boolean> path) {

        if (!checkRoot()) {
            root = new Node(question);
        }

        Node runner = root;
        boolean finans = path.remove(path.size());
        for (Boolean p : path) {
            if (p) {
                runner = runner.getT();
            } else {
                runner = runner.getF();
            }
        }

        if (finans) {
            runner.setT(new Node(question));
        } else {
            runner.setF(new Node(question));
        }

    }

    public String get(ArrayList<Boolean> path) {

        if (!checkRoot()) {
            throw new RuntimeException("Kein Rootelement vorhanden");
        }
        if (path.size() == 0) {
            return root.getValue();
        }
        Node runner = root;

        boolean finans = path.remove(path.size() - 1);
        for (Boolean p : path) {
            if (p) {
                runner = runner.getT();
            } else {
                runner = runner.getF();
            }
        }
        return runner.getValue();

    }

}

/**
 * Node
 */
class Node {

    private String value;
    private Node t;
    private Node f;

    public Node(String value, Node t, Node f) {
        this.value = value;
        this.t = t;
        this.f = f;
    }

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getT() {
        return t;
    }

    public void setT(Node t) {
        this.t = t;
    }

    public Node getF() {
        return f;
    }

    public void setF(Node f) {
        this.f = f;
    }

}