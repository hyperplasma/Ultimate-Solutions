package valid_palindrome_ii

func validPalindrome(s string) bool {
	low, high := 0, len(s)-1
	for low < high {
		if s[low] == s[high] {
			low++
			high--
		} else {
			return checkPalindrome(s, low, high-1) || checkPalindrome(s, low+1, high)
		}
	}
	return true
}

func checkPalindrome(s string, low, high int) bool {
	for i, j := low, high; i < j; i, j = i+1, j-1 {
		if s[i] != s[j] {
			return false
		}
	}
	return true
}
