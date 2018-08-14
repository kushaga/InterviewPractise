public class AddLinkList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new ListNode(0);
        }
        int size1 = size(l1);
        int size2 = size(l2);

        if (size1 > size2) {
            if (l2 == null) {
                l2 = new ListNode(0);
                size2++;
            }
            ListNode iter = l2;

            while (iter.next != null) {
                iter = iter.next;
            }

            for (int i = 0; i <= size1 - size2; i++) {
                iter.next = new ListNode(0);
                iter = iter.next;
            }
        } else if (size1 < size2) {
            if (l1 == null) {
                l1 = new ListNode(0);
                size1++;
            }
            ListNode iter = l1;

            while (iter.next != null) {
                iter = iter.next;
            }

            for (int i = 0; i < size2 - size1; i++) {
                iter.next = new ListNode(0);
                iter = iter.next;
            }
        }

        //add the numbers
        int carry = 0;
        ListNode iter = l1;
        while (l1 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            l1.val = sum;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (carry > 0) {
            ListNode iter1 = iter;
            while (iter1.next != null) {
                iter1 = iter1.next;
            }
            iter1.next = new ListNode(carry);
        }
        return iter;
    }

    public static int size(ListNode l) {
        int cnt = 0;
        if (l == null) {
            return 0;
        } else {
            while (l != null) {
                l = l.next;
                cnt++;
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        AddLinkList list = new AddLinkList();
        ListNode listNode = new ListNode(9);
        listNode.next = new ListNode(9);
        listNode.next.next = new ListNode(9);
        listNode.next.next.next = new ListNode(9);
        ListNode iter = list.addTwoNumbers(new ListNode(1), listNode);
        while (iter!= null) {
            System.out.println(iter.val);
            iter = iter.next;
        }
    }

}
