package utils;

public class BinBaum {
    public static final int NLR = 0;
    public static final int LNR = 1;
    public static final int RNL = 2;

    private Node root;

    public int findMin() {
        checkRoot();
        Node runner = root;

        // gehe immer weiter nach links, bis ...
        while (runner.getLeft() != null) {
            runner = runner.getLeft();
        }

        return runner.getData();
    }

    private void checkRoot() {
        if (root == null) {
            throw new IllegalStateException("Kein Root-Element vorhanden");
        }
    }

    public int findMax() {
        checkRoot();
        Node runner = root;

        while (runner.getRight() != null) {
            runner = runner.getRight();
        }

        return runner.getData();
    }

    public String ausgeben() {
        return ausgeben(LNR);
    }

    public String ausgeben(int order) {
        checkRoot();
        return switch (order) {
            case NLR -> root.nlr();
            case LNR -> root.lnr();
            case RNL -> root.rnl();
            default -> throw new IllegalStateException("Unexpected value: " + order);
        };
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node runner = root;

            while (true) {
                if (runner.getData() < data) {
                    if (runner.getRight() == null) {
                        runner.setRight(newNode);
                        break;
                    }

                    runner = runner.getRight();
                } else {
                    if (runner.getLeft() == null) {
                        runner.setLeft(newNode);
                        break;
                    }

                    runner = runner.getLeft();
                }
            }
        }
    }

    public int getDepth() {
        checkRoot();
        return depth(root, 0);
    }

    private int depth(Node current, int depth) {
        int leftDepth = depth;
        int rightDepth = depth;

        if (current.getLeft() != null) {
            leftDepth = depth(current.getLeft(), depth + 1);
        }

        if (current.getRight() != null) {
            rightDepth = depth(current.getRight(), depth + 1);
        }

        if (leftDepth > rightDepth) {
            return leftDepth;
        } else {
            return rightDepth;
        }
    }

    private String tree = "";

    public String printTree() {
        printTree(root, 0);
        return tree;
    }

    private void printTree(Node currentNode, int depth) {
        String tab = "";
        for (int i = 0; i < depth; i++) {
            tab = tab + "-";
        }

        String s = ": ";
        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            s = "";
        }

        tree = tree + tab + currentNode.getData() + s + "\n";
        if (currentNode.getLeft() != null) {
            printTree(currentNode.getLeft(), depth + 1);
        }
        if (currentNode.getRight() != null) {
            printTree(currentNode.getRight(), depth + 1);
        }
    }
}

class Node {
    private int data;
    private Node left;
    private Node right;

    public String nlr() {
        // Gibt Wert vom aktuellen Knoten aus
        String s = getData() + " ";

        // Gib linken Teilbaum aus
        if (left != null) {
            s += left.nlr();
        }

        // Gib rechten Teilbaum aus
        if (right != null) {
            s += right.nlr();
        }

        return s;
    }

    public String lnr() {
        // Gib linken Teilbaum aus
        if (left != null) {
            left.lnr();
        }

        // Gibt Wert vom aktuellen Knoten aus
        System.out.print(getData() + " ");

        // Gib rechten Teilbaum aus
        if (right != null) {
            right.lnr();
        }

        return "blub";
    }

    public String rnl() {
        // Gib rechten Teilbaum aus
        if (right != null) {
            right.rnl();
        }

        // Gibt Wert vom aktuellen Knoten aus
        System.out.print(getData() + " ");

        // Gib linken Teilbaum aus
        if (left != null) {
            left.rnl();
        }

        return "bla";
    }

    // Konstruktoren
    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // Getter und Setter
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}