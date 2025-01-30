package intersection_of_two_arrays_ii

import (
	"fmt"
	"testing"
)

func Test_intersect(t *testing.T) {
	tests := []struct {
		nums1 []int
		nums2 []int
	}{
		{[]int{1, 2, 2, 1}, []int{2, 2}},
		{[]int{4, 9, 5}, []int{9, 4, 9, 8, 4}},
	}

	for _, tt := range tests {
		fmt.Println(intersect(tt.nums1, tt.nums2))
	}
}
