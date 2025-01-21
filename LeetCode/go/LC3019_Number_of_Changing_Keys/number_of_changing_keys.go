package number_of_changing_keys

import "unicode"

func countKeyChanges(s string) int {
	cnt := 0
	for i := 1; i < len(s); i++ {
		if unicode.ToLower(rune(s[i])) != unicode.ToLower(rune(s[i-1])) {
			cnt++
		}
	}
	return cnt
}
