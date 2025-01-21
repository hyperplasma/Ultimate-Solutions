package shortest_subarray_with_or_at_least_k_i

import "math"

func minimumSubarrayLength(nums []int, k int) int {
	cnt := math.MaxInt64
	for l := 0; l < len(nums); l++ {
		val := 0
		for r := l; r < len(nums); r++ {
			val |= nums[r]
			if val >= k {
				cnt = min(cnt, r-l+1)
				break
			}
		}
	}
	if cnt == math.MaxInt64 {
		return -1
	}
	return cnt
}
