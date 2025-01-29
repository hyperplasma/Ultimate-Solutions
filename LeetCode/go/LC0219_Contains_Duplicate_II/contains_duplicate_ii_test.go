package contains_duplicate_ii

import (
	"fmt"
	"testing"
)

func Test_containsNearbyDuplicate(t *testing.T) {
	tests := []struct {
		nums []int
		k    int
	}{
		{[]int{1, 2, 3, 1}, 3},
		{[]int{1, 0, 1, 1}, 1},
		{[]int{1, 2, 3, 1, 2, 3}, 2},
	}

	for _, test := range tests {
		fmt.Println(containsNearbyDuplicate(test.nums, test.k))
	}
}
