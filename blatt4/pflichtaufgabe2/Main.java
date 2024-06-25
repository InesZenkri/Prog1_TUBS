import binaryTree.BinaryTreeUtils;
import binaryTree.Element;
import binaryTree.Pair;

public class Main {
    public static void main(String[] args) {
        Pair[] data = {
            new Pair(1, "1"),
            new Pair(4, "4"),
            new Pair(7, "7"),
            new Pair(8, "8"),
            new Pair(13, "13"),
            new Pair(21, "21"),
            new Pair(42, "42")
        };

        bubbleSort(data);//in this example it is already sorted, but we sort it anyway:)

        // we create a binary tree from the sorted array
        Element root = BinaryTreeUtils.createBinaryTree(data, 0, data.length);

        //print the tree in different orders
        System.out.println("Inorder:");
        BinaryTreeUtils.inorder(root);
        System.out.println();

        System.out.println("Preorder:");
        BinaryTreeUtils.preorder(root);
        System.out.println();

        System.out.println("Postorder:");
        BinaryTreeUtils.postorder(root);
        System.out.println();

        //find the height of the tree and print it
        int height = BinaryTreeUtils.getHeight(root);
        System.out.println("Höhe des Baums: " + height);
    }

    // bubble sort
    public static void bubbleSort(Pair[] data) {
        boolean swapped;
        for (int i = 0; i < data.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    Pair temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
