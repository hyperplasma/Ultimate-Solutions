package LC0002_AddTwoNumbers;

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