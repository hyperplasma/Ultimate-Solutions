package permutations_ii

import (
	"fmt"
	"testing"
)

func Test_permuteUnique(t *testing.T) {
	tests := []struct {
		nums []int
	}{
		{[]int{1, 1, 2}},
		{[]int{1, 2, 3}},
	}

	for _, tt := range tests {
		fmt.Println(permuteUnique(tt.nums))
	}
}
