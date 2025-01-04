package merge_two_sorted_lists

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	if list1 == nil {
		return list2
	}
	if list2 == nil {
		return list1
	}

	head := &ListNode{}
	p1 := list1
	p2 := list2
	p := head
	for p1 != nil && p2 != nil {
		if p1.Val < p2.Val {
			p.Next = p1
			p1 = p1.Next
			p = p.Next
		} else {
			p.Next = p2
			p2 = p2.Next
			p = p.Next
		}
	}
	for p1 != nil {
		p.Next = p1
		p1 = p1.Next
		p = p.Next
	}
	for p2 != nil {
		p.Next = p2
		p2 = p2.Next
		p = p.Next
	}
	return head.Next
}

type ListNode struct {
	Val  int
	Next *ListNode
}
