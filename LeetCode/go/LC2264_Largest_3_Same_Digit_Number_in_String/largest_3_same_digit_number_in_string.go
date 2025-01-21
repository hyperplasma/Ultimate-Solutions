package largest_3_same_digit_number_in_string

import (
	"strconv"
	"strings"
)

func largestGoodInteger(num string) string {
	for i := 9; i >= 0; i-- {
		str := strings.Repeat(strconv.Itoa(i), 3)
		if strings.Contains(num, str) {
			return str
		}
	}
	return ""
}
