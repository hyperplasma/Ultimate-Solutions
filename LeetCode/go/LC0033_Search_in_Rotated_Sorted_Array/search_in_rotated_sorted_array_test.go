package search_in_rotated_sorted_array

import (
	"fmt"
	"testing"
)

func Test_search(t *testing.T) {
	tests := []struct {
		nums   []int
		target int
	}{
		{[]int{4, 5, 6, 7, 0, 1, 2}, 0},
		{[]int{4, 5, 6, 7, 0, 1, 2}, 3},
		{[]int{1}, 0},
	}

	for _, test := range tests {
		fmt.Println(search(test.nums, test.target))
	}
}
