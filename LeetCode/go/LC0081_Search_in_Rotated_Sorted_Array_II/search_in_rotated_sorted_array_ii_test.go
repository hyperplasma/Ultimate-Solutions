package LC0081_Search_in_Rotated_Sorted_Array_II

import (
	"fmt"
	"testing"
)

func Test_search(t *testing.T) {
	tests := []struct {
		nums   []int
		target int
	}{
		{[]int{2, 5, 6, 0, 0, 1, 2}, 0},
		{[]int{2, 5, 6, 0, 0, 1, 2}, 3},
	}

	for _, test := range tests {
		fmt.Println(search(test.nums, test.target))
	}
}
