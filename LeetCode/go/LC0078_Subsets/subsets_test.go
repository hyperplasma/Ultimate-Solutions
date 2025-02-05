package subsets

import (
	"fmt"
	"testing"
)

func Test_subsets(t *testing.T) {
	tests := []struct {
		nums []int
	}{
		{[]int{1, 2, 3}},
		{[]int{0}},
	}

	for _, tt := range tests {
		fmt.Println(subsets(tt.nums))
	}
}
