package number_of_ways_to_split_array

func waysToSplitArray(nums []int) int {
	n := len(nums)
	leftSum, rightSum := 0, 0
	for _, num := range nums {
		rightSum += num
	}

	res := 0
	for i := 0; i < n-1; i++ {
		leftSum += nums[i]
		rightSum -= nums[i]
		if leftSum >= rightSum {
			res++
		}
	}
	return res
}
