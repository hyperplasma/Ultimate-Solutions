package find_closest_number_to_zero

import "math"

func findClosestNumber(nums []int) int {
	minAbs := int(math.Abs(float64(nums[0])))
	res := nums[0]
	for i := 1; i < len(nums); i++ {
		abs := int(math.Abs(float64(nums[i])))
		if abs < minAbs {
			minAbs = abs
			res = nums[i]
		} else if abs == minAbs {
			res = max(res, nums[i])
		}
	}
	return res
}
