package reverse_string_ii

import (
	"fmt"
	"testing"
)

func Test_reverseStr(t *testing.T) {
	tests := []struct {
		s string
		k int
	}{
		{"abcdefg", 2},
	}

	for _, test := range tests {
		fmt.Println(reverseStr(test.s, test.k))
	}
}
