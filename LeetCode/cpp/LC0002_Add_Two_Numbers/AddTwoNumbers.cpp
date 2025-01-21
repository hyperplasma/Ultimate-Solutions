#include <iostream>
#include "ListNode.h"

using namespace std;

class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        ListNode *res = new ListNode;

        int carry = 0;
        ListNode *p1 = l1, *p2 = l2, *r = nullptr;
        while (p1 || p2) {
            if (p1) {
                carry += p1->val;
                p1 = p1->next;
            }
            if (p2) {
                carry += p2->val;
                p2 = p2->next;
            }
            ListNode *s = new ListNode;
            s->next = nullptr;
            s->val = carry % 10;
            carry /= 10;

            if (!r) {
                res = s;
            } else {
                r->next = s;
            }
            r = s;
        }

        if (carry) {
            ListNode *s = new ListNode;
            s->next = nullptr;
            s->val = carry;
            r->next = s;
        }

        return res;
    }
};