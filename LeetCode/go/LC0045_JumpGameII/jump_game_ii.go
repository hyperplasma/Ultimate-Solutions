package jump_game_ii

func jump(nums []int) int {
	end := 0
	maxPos := 0
	steps := 0
	for i := 0; i < len(nums)-1; i++ {
		maxPos = max(maxPos, i+nums[i])
		if i == end {
			end = maxPos
			steps++
		}
	}
	return steps
}
