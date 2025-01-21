package minimum_operations_to_exceed_threshold_value_i

func minOperations(nums []int, k int) int {
	cnt := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] < k {
			cnt++
		}
	}
	return cnt
}
