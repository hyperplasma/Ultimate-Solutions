package subsets

func subsets(nums []int) (res [][]int) {
	var dfs func(int, []int)
	dfs = func(cur int, path []int) {
		if cur == len(nums) {
			res = append(res, append([]int(nil), path...))
			return
		}
		path = append(path, nums[cur])
		dfs(cur+1, path)
		path = path[:len(path)-1]
		dfs(cur+1, path)
	}
	dfs(0, []int{})
	return
}
