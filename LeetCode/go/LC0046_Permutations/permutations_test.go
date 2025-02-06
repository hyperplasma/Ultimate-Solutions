package permutations

import (
	"fmt"
	"testing"
)

func Test_permutations(t *testing.T) {
	tests := []struct {
		nums []int
	}{
		{[]int{1, 2, 3}},
		{[]int{0, 1}},
	}

	for _, tt := range tests {
		fmt.Println(permute(tt.nums))
	}
}
