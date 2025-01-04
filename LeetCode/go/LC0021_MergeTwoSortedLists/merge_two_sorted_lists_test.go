package merge_two_sorted_lists

import (
	"fmt"
	"testing"
)

func Test_mergeTwoLists(t *testing.T) {
	list1 := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 4}}}
	list2 := &ListNode{Val: 1, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4}}}
	list := mergeTwoLists(list1, list2)
	for list != nil {
		fmt.Println(list.Val)
		list = list.Next
	}
}
