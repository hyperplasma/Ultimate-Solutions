<?php

include "ListNode.php";

class Solution {

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function addTwoNumbers(ListNode $l1, ListNode $l2): ListNode {
        $l3 = new ListNode();
        $p = $l1;
        $q = $l2;
        $r = $l3;

        $carry = 0;
        while ($p != null || $q != null || $carry > 0) {
            $sum = $carry;
            if ($p != null) {
                $sum += $p->val;
            }
            if ($q != null) {
                $sum += $q->val;
            }
            $carry = floor($sum / 10);

            $r->next = new ListNode($sum % 10);
            $r = $r->next;
            if ($p != null) {
                $p = $p->next;
            }
            if ($q != null) {
                $q = $q->next;
            }
        }

        return $l3->next;
    }
}

// test
$node1 = new ListNode(2);
$node2 = new ListNode(4);
$node3 = new ListNode(3);
$node4 = new ListNode(5);
$node5 = new ListNode(6);
$node6 = new ListNode(4);
$node1->next = $node2;
$node2->next = $node3;
$node4->next = $node5;
$node5->next = $node6;
var_dump(new Solution()->addTwoNumbers($node1, $node4));