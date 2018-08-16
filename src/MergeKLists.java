//Merge K sorted lists
public class MergeKLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists != null && lists.length > 0) {
            return mergeLists(lists, 0, lists.length - 1, lists.length);
        }
        return null;
    }

    public ListNode mergeLists(ListNode[] lists, int l, int r, int n) {
        if (l <= r) {
            if (l == r) {
                return lists[l];
            }
            int mid = (l + r) / 2;
            ListNode lMerge = mergeLists(lists, l, mid, n);
            ListNode rMerge = mergeLists(lists, mid + 1, r, n);
            return merge(lMerge, rMerge);
        }
        return null;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l2 == null && l1 != null) {
            return l1;
        } else {
            ListNode merged = null;
            if (l1.val < l2.val) {
                merged = l1;
                l1 = l1.next;
            } else {
                merged = l2;
                l2 = l2.next;
            }
            ListNode temp = merged;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    temp.next = l1;
                    temp = temp.next;
                    l1 = l1.next;
                } else {
                    temp.next = l2;
                    temp = temp.next;
                    l2 = l2.next;
                }
            }
            if (l1 == null && l2 != null) {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
            if (l2 == null && l1 != null) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }
            return merged;
        }
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] listNodes = { l1, l2, l3 };
        MergeKLists mergeKLists = new MergeKLists();
        ListNode merged = mergeKLists.mergeKLists(listNodes);
        while (merged != null) {
            System.out.print(merged.val + "->");
            merged = merged.next;
        }
    }
}
