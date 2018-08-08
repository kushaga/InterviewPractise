package tree;

public class Diameter {
    Node root;

    public static void main(String[] args) {
        Diameter tree = new Diameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(diameter(tree.root));
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    static int diameter(Node n) {
        if (n == null) {
            return 0;
        }
        int ldiamter = diameter(n.left);
        int rdiamter = diameter(n.right);

        int lheight = height(n.left);
        int rheight = height(n.right);

        return Math.max(lheight + rheight + 1, Math.max(ldiamter, rdiamter));
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int n) {
            val = n;
            this.left = null;
            this.right = null;
        }
    }
}
