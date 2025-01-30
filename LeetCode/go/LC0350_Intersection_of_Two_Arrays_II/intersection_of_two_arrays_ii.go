package intersection_of_two_arrays_ii

func intersect(nums1 []int, nums2 []int) []int {
	if len(nums1) > len(nums2) {
		return intersect(nums2, nums1)
	}

	m := make(map[int]int)
	for _, num := range nums1 {
		m[num]++
	}

	res := make([]int, 0)
	for _, num := range nums2 {
		cnt := m[num]
		if cnt > 0 {
			res = append(res, num)
			cnt--
			if cnt > 0 {
				m[num] = cnt
			} else {
				delete(m, num)
			}
		}
	}
	return res
}
