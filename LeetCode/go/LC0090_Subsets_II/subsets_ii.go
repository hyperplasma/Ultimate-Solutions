package subsets_ii

import "sort"

func subsetsWithDup(nums []int) (res [][]int) {
	sort.Ints(nums)
	var dfs func(bool, int, []int)
	dfs = func(choosePre bool, cur int, path []int) {
		if cur == len(nums) {
			res = append(res, append([]int{}, path...))
			return
		}
		dfs(false, cur+1, path)
		if !choosePre && cur > 0 && nums[cur] == nums[cur-1] {
			return
		}
		path = append(path, nums[cur])
		dfs(true, cur+1, path)
		path = path[:len(path)-1]
	}
	dfs(false, 0, []int{})
	return
}
