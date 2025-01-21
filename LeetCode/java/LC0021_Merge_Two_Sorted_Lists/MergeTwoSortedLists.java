package LC0021_MergeTwoSortedLists;


/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">Merge Two Sorted Lists</a>
 * 递归；链表
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list = solution.mergeTwoLists(list1, list2);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode();
        ListNode p1 = list1, p2 = list2, p = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head.next;
    }
}
