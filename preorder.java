import java.util.*;

public class preorder {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class binaryTree {
        static int index = -1;

        public static Node buildTree(int nodes[]) {
            index++;

            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // Preorder
        public static void preorder(Node root) {
            if (root == null) return;

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // Inorder
        public static void inorder(Node root) {
            if (root == null) return;

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // Postorder
        public static void postorder(Node root) {
            if (root == null) return;

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // Level Order
        public static void levelOrder(Node root) {
            if (root == null) return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                Node curr = q.remove();

                System.out.print(curr.data + " ");

                if (curr.left != null)
                    q.add(curr.left);

                if (curr.right != null)
                    q.add(curr.right);
            }
        }

        // Height
        public static int height(Node root) {
            if (root == null) {
                return 0;
            }

            int leftheight = height(root.left);
            int rightheight = height(root.right);

            return Math.max(leftheight, rightheight) + 1;
        }
        public static int countNode(Node root){
            if(root==null){
                return 0;
            }
            return countNode(root.left)+countNode(root.right)+1;

        }
        public static int sumOfNodes(Node root){
            if(root==null){
                return 0;
            }
            return sumOfNodes(root.left)+sumOfNodes(root.right)+root.data;
        }
    }

    public static void main(String[] args) {

        int nodes[] = {
            1, 2, 4, -1, -1, 5, -1, -1,
            3, -1, 6, -1, -1
        };

        binaryTree tree = new binaryTree();

        Node root = tree.buildTree(nodes);

        System.out.print("Preorder: ");
        tree.preorder(root);

        System.out.print("Inorder: ");
        tree.inorder(root);

        System.out.print("Postorder: ");
        tree.postorder(root);

        System.out.print("Level-order: ");
        tree.levelOrder(root);

        System.out.print("Height of the tree: ");
        System.out.println(tree.height(root));

        System.out.print("Count of nodes in the tree: ");
        System.out.println(tree.countNode(root));

        System.out.print("Sum of all nodes in the tree: ");
        System.out.println(tree.sumOfNodes(root));
    }
}