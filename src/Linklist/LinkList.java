package Linklist;

public class LinkList {
    public static class Node {
        int num;
        Node next;

        public Node(int n) {
            this.num = n;
            this.next = null;
        }
    }

    public static Node head;

    public static Node reverseUtil(Node curr, Node prev) {
        if (curr.next == null) {
            head = curr;
            curr.next = prev;
            return head;
        } else {
            reverseUtil(curr.next, curr);
            curr.next = prev;
            return head;
        }
    }

    public static void print(Node curr) {
        if (curr.next == null) {
            System.out.println(curr.num);
            return;
        } else {
            System.out.println(curr.num);
            print(curr.next);
            return;
        }
    }

    public static int length(Node n) {
        if (n.next == null) {
            return 1;
        } else {
            return 1+length(n.next);
        }
    }

    public static void main(String args[]) {
        head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        print(head);
        reverseUtil(head, null);
        print(head);
        System.out.println("lenght:" + length(head));
    }
}
