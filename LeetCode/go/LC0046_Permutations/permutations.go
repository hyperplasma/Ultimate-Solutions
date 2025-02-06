package permutations

func permute(nums []int) (res [][]int) {
	output := make([]int, len(nums))
	for i := range nums {
		output[i] = nums[i]
	}

	var backtrack func(int, int, []int, *[][]int)
	backtrack = func(cur int, n int, output []int, res *[][]int) {
		if cur == n {
			*res = append(*res, append([]int{}, output...))
		}

		for i := cur; i < n; i++ {
			output[cur], output[i] = output[i], output[cur]
			backtrack(cur+1, n, output, res)
			output[cur], output[i] = output[i], output[cur]
		}
	}

	backtrack(0, len(nums), output, &res)
	return res
}
