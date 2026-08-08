class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {

    public static void main(String[] args) {

        Node root = new Node(10);

        root.left = new Node(5);
        root.right = new Node(20);

        root.left.left = new Node(3);
        root.left.right = new Node(7);

        root.right.left = new Node(15);
        root.right.right = new Node(25);

        // Print tree
       System.out.println("Root: " + root.data);
        System.out.println("Left: " + root.left.data);
        System.out.println("Right: " + root.right.data);
        System.out.println("Left-Left: " + root.left.left.data);
        System.out.println("Left-Right: " + root.left.right.data);
        System.out.println("Right-Left: " + root.right.left.data);
        System.out.println("Right-Right: " + root.right.right.data);
        
    }
}