package binary_search

var (
	target1 int
	target2 float64
)

// BinarySearchL 查找左边界，即第一个满足条件的元素下标 (lower_bound)
func BinarySearchL(l, r int) int {
	for l < r {
		mid := (l + r) >> 1
		if ge(mid, target1) {
			r = mid // 如果中点值符合条件，则继续在左边查找
		} else {
			l = mid + 1
		}
	}
	return l
}

// BinarySearchR 查找右边界，即最后一个满足条件的元素下标 (upper_bound的前驱)
func BinarySearchR(l, r int) int {
	for l < r {
		mid := (l + r + 1) >> 1
		if le(mid, target1) {
			l = mid // 如果中点值符合条件（≤），则继续在右边查找
		} else {
			r = mid - 1
		}
	}
	return r
}

func BinarySearchF(l, r float64) float64 {
	for l < r {
		mid := (l + r) / 2
		if ge2(mid, target2) {
			r = mid // 目标在左边，更新右边界
		} else {
			l = mid
		}
	}
	return l // 返回左边界，即为目标值的估计
}

func ge(mid, target int) bool {
	// ...
	return mid >= target
}

func ge2(mid float64, target float64) bool {
	// ...
	return mid-target >= 0
}

func le(mid, target int) bool {
	// ...
	return mid <= target
}
