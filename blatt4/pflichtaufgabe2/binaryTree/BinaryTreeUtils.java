package binaryTree;

public final class BinaryTreeUtils { //final means that the class cannot be extended or inherited or overridden

    public static Element createBinaryTree(Pair[] data, int left, int right) {
        if (left >= right) {//if the left index is greater or equal to the right index, return null
            return null;
        }
        int m = (left + right) / 2; //calculate the middle index
        Element ex = new Element(data[m]); //create a new element with the data at the middle index
        ex.left = createBinaryTree(data, left, m);//recursively create the left subtree
        if (ex.left != null) { //if the left subtree is not null, set the parent of the left subtree to the current element
            ex.left.parent = ex;
        }
        ex.right = createBinaryTree(data, m + 1, right);//recursively create the right subtree
        if (ex.right != null) {//if the right subtree is not null, set the parent of the right subtree to the current element
            ex.right.parent = ex;
        }
        return ex;//return the current element
    }

    public static void inorder(Element root) {
        if (root != null) {
            inorder(root.left);//recursively traverse the left subtree
            System.out.print(root.data.val + " ");//print the value of the current element
            inorder(root.right);//recursively traverse the right subtree
        }
    }
    //same as inorder, but the print statement is before the recursive calls
    public static void preorder(Element root) {
        if (root != null) {
            System.out.print(root.data.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    //same as inorder, but we want to print the value of the current element last 
    public static void postorder(Element root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data.val + " ");
        }
    }

    public static int getHeight(Element root) {
        if (root == null) {//if the root is null, the height is 0
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));//return 1 plus the maximum height of the left and right subtrees
    }
}
