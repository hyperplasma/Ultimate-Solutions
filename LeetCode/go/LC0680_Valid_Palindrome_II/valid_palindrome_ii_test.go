package valid_palindrome_ii

import (
	"fmt"
	"testing"
)

func Test_validPalindrome(t *testing.T) {
	tests := []struct {
		s string
	}{
		{"aba"},
		{"abca"},
		{"abc"},
	}

	for _, tt := range tests {
		fmt.Println(validPalindrome(tt.s))
	}
}
