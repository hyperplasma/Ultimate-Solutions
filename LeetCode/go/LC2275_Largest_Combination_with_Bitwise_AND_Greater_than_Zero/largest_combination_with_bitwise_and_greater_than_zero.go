package largest_combination_with_bitwise_and_greater_than_zero

import "slices"

func largestCombination(candidates []int) int {
	cnt := [24]int{0}
	for _, v := range candidates {
		for i := 0; v > 0; i++ {
			cnt[i] += v & 1
			v >>= 1
		}
	}
	return slices.Max(cnt[:])
}
