package LC0026_RemoveDuplicatesFromSortedArray

func removeDuplicates(nums []int) int {
	cnt := 0
	for i := 1; i < len(nums); i++ {
		if nums[i] != nums[cnt] {
			cnt++
			nums[cnt] = nums[i]
		}
	}
	return cnt + 1
}
