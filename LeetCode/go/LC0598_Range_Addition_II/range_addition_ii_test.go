package range_addition_ii

import (
	"fmt"
	"testing"
)

func Test_maxCount(t *testing.T) {
	tests := []struct {
		m   int
		n   int
		ops [][]int
	}{
		{3, 3, [][]int{{2, 2}, {3, 3}}},
	}

	for _, test := range tests {
		fmt.Println(maxCount(test.m, test.n, test.ops))
	}
}
