package LeetCode.LC0002_AddTwoNumbers;

/**
 * <a href="https://leetcode-cn.com/problems/add-two-numbers/">Add Two Numbers</a>
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = solution.addTwoNumbers(l1, l2);
        if (result != null) {
            System.out.print(result.val + " ");
        }
    }
}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = l3;

        int carry = 0;
        while (p != null || q != null || carry > 0) {
            int sum = carry;
            if (p != null) {
                sum += p.val;
            }
            if (q != null) {
                sum += q.val;
            }
            carry = sum / 10;

            r.next = new ListNode(sum % 10);
            r = r.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        return l3.next;
    }
}