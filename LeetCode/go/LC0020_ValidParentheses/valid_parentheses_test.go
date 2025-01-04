package LC0020_ValidParentheses

import (
	"fmt"
	"testing"
)

func Test_isValid(t *testing.T) {
	fmt.Println(isValid("()[]{}"))
	fmt.Println(isValid("([)]"))
}
