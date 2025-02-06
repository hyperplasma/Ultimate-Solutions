package permutations_ii

import "sort"

func permuteUnique(nums []int) (res [][]int) {
	var path []int
	n := len(nums)
	visited := make([]bool, n)

	var backtrack func(int)
	backtrack = func(cur int) {
		if cur == n {
			res = append(res, append([]int{}, path...))
			return
		}

		for i := 0; i < n; i++ {
			if visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) {
				continue
			}
			visited[i] = true
			path = append(path, nums[i])
			backtrack(cur + 1)
			path = path[:len(path)-1]
			visited[i] = false
		}
	}

	sort.Ints(nums)
	backtrack(0)
	return res
}
