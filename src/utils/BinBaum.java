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
        boolean finans = path.remove(path.size() - 1);
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
        int i = 1;

        while (runner != null && i < path.size()) {

            if (path.get(i - 1)) {
                System.err.println("u");
                runner = runner.getT();
            } else {

                runner = runner.getF();

            }
            i++;
        }
        String temp = runner == null ? null : runner.getValue();

        System.out.println(temp);

        return temp;

    }

    public void debug() {
        debug(root);
    }

    private void debug(Node node) {

        if (node == null) {
            return;
        }

        debug(node.getF());
        System.out.println(node.getValue());
        // debug(node.getT());

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