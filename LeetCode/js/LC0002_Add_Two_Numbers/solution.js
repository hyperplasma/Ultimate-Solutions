import {ListNode} from "./ListNode.js";

/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
    let l3 = new ListNode();
    let p = l1, q = l2, r = l3;

    let carry = 0;
    while (p != null || q != null || carry > 0) {
        let sum = carry;
        if (p != null) {
            sum += p.val;
        }
        if (q != null) {
            sum += q.val;
        }
        carry = Math.floor(sum / 10);

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
};

function test() {
    let l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    let l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
    let l3 = addTwoNumbers(l1, l2);
    while (l3 != null) {
        console.log(l3.val);
        l3 = l3.next;
    }
}

test();