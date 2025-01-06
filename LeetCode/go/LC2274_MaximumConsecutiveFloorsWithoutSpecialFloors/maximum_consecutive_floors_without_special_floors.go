package maximum_consecutive_floors_without_special_floors

import "slices"

func maxConsecutive(bottom int, top int, special []int) int {
	slices.Sort(special)
	res := max(special[0]-bottom, top-special[len(special)-1])
	for i := 1; i < len(special); i++ {
		res = max(res, special[i]-special[i-1]-1)
	}
	return res
}
