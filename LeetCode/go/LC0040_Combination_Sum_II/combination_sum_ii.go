package LC0040_Combination_Sum_II

import "sort"

func combinationSum2(candidates []int, target int) [][]int {
	res := [][]int{}
	sort.Ints(candidates)
	backtrack(candidates, target, 0, []int{}, &res)
	return res
}

func backtrack(candidates []int, target int, start int, path []int, res *[][]int) {
	if target == 0 {
		*res = append(*res, append([]int{}, path...))
		return
	}
	for i := start; i < len(candidates); i++ {
		if i > start && candidates[i] == candidates[i-1] {
			continue
		}
		if target < candidates[i] {
			break
		}
		path = append(path, candidates[i])
		backtrack(candidates, target-candidates[i], i+1, path, res)
		path = path[:len(path)-1]
	}
}
