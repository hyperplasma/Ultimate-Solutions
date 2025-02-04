package sort_array_by_parity_ii

import (
	"fmt"
	"testing"
)

func Test_sortArrayByParityII(t *testing.T) {
	tests := []struct {
		nums []int
	}{
		{[]int{4, 2, 5, 7}},
		{[]int{2, 3}},
	}

	for _, tt := range tests {
		fmt.Println(sortArrayByParityII(tt.nums))
	}
}
