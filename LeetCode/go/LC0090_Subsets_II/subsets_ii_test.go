package subsets_ii

import (
	"fmt"
	"testing"
)

func Test_subsetsWithDup(t *testing.T) {
	tests := []struct {
		nums []int
	}{
		{[]int{1, 2, 2}},
		{[]int{0}},
	}

	for _, tt := range tests {
		fmt.Println(subsetsWithDup(tt.nums))
	}
}
