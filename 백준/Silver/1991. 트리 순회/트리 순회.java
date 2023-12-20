import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int size = Integer.parseInt(scanner.nextLine().trim());

        Node root = initTree(size);

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);

        scanner.close();
    }

    private static Node initTree(int size) {
        Node[] nodeArray = new Node[26];
        String inputString = scanner.nextLine().trim();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, " ");
        char value = stringTokenizer.nextToken().charAt(0);
        char leftValue = stringTokenizer.nextToken().charAt(0);
        char rightValue = stringTokenizer.nextToken().charAt(0);
        Node root = new Node(value, null, null);
        nodeArray[value - 'A'] = root;
        if (leftValue != '.') {
            Node leftNode = new Node(leftValue, null, null);
            root.left = leftNode;
            nodeArray[leftValue - 'A'] = leftNode;
        }
        if (rightValue != '.') {
            Node rightNode = new Node(rightValue, null, null);
            root.right = rightNode;
            nodeArray[rightValue - 'A'] = rightNode;
        }

        for (int i = 1; i < size; i++) {
            inputString = scanner.nextLine().trim();
            stringTokenizer = new StringTokenizer(inputString, " ");
            value = stringTokenizer.nextToken().charAt(0);
            leftValue = stringTokenizer.nextToken().charAt(0);
            rightValue = stringTokenizer.nextToken().charAt(0);
            Node currentNode = nodeArray[value - 'A'];
            nodeArray[value - 'A'] = currentNode;
            if (leftValue != '.') {
                Node leftNode = new Node(leftValue, null, null);
                currentNode.left = leftNode;
                nodeArray[leftValue - 'A'] = leftNode;
            }
            if (rightValue != '.') {
                Node rightNode = new Node(rightValue, null, null);
                currentNode.right = rightNode;
                nodeArray[rightValue - 'A'] = rightNode;
            }
        }

        return root;
    }

    private static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue());
        preorder(root.left);
        preorder(root.right);
    }

    private static void inorder(Node root) {
        if (root == null ) {
            return;
        }
        inorder(root.left);
        System.out.print(root.getValue());
        inorder(root.right);
    }

    private static void postorder(Node root) {
        if (root == null ) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.getValue());
    }

    static class Node {
        private char value;
        public Node left;
        public Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }


        public char getValue() {
            return value;
        }
    }
}
