package utils;

import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import logice.questions;

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

    public String get(ArrayList<Boolean> path) throws Exception {

        if (!checkRoot()) {
            throw new Exception("No root");
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
        return root.getValue();

    }

}

/**
 * Node
 */
public class Node {

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