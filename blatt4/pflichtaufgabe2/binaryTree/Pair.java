package binaryTree;

public class Pair implements Comparable<Pair> {
    public int key;
    public String val;

    public Pair(int key, String val) {
        this.key = key;
        this.val = val;
    }

    @Override 
    //compare the keys of the pairs, the compare does automatically the right thing
    public int compareTo(Pair other) {
        return Integer.compare(this.key, other.key);
    }
}
