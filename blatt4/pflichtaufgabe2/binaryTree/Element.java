package binaryTree;

public class Element {// our node 
    public Pair data;
    public Element left;
    public Element right;
    public Element parent;
    // constructor
    public Element(Pair data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
