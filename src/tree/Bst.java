package tree;

public class Bst {
    private static Node head;

    public static void main(String[] args) {
        int arr[] = { 200, 2, 3, 4, 40, 10 };
        for (int i : arr) {
            head = insert(i, head);
        }
        inorder(head);
    }

    /**
     *
     * @param n
     * @param head
     * @return
     */
    public static Node insert(int n, Node head) {
        if (head == null) {
            head = new Node(n, null, null);
            return head;
        } else {
            if (head.val < n) {
                //right subtree
                head.right = insert(n, head.right);
            } else {
                //left subtree
                head.left = insert(n, head.left);
            }
            return head;
        }
    }

    //todo implement delete

    /**
     *
     * @param head
     */
    public static void inorder(Node head) {
        if (head == null) {
            return;
        } else {
            inorder(head.left);
            System.out.println(head.val);
            inorder(head.right);
        }
    }

    /**
     *
     * @param head
     */
    public static void preOrder(Node head) {
        if (head == null) {
            return;
        } else {
            System.out.println(head.val);
            inorder(head.left);
            inorder(head.right);
        }
    }

    /**
     *
     * @param head
     */
    public static void postOrder(Node head) {
        if (head == null) {
            return;
        } else {
            inorder(head.left);
            inorder(head.right);
            System.out.println(head.val);
        }
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
