package spiral_matrix_ii

import (
	"fmt"
	"testing"
)

func Test_generateMatrix(t *testing.T) {
	tests := []struct {
		n int
	}{
		{3},
		{1},
	}

	for _, tt := range tests {
		fmt.Println(generateMatrix(tt.n))
	}
}
