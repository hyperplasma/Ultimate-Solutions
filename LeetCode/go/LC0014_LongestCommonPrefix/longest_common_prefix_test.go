package longest_common_prefix

import (
	"fmt"
	"testing"
)

func Test_longestCommonPrefix(t *testing.T) {
	strs := []string{"flower", "flow", "flight"}
	fmt.Println(longestCommonPrefix(strs))
}
