package sort

import (
	"fmt"
	"sort"
)

// 示例：按值排序
func sortByValue() {
	testMap := map[string]int{
		"one":   1,
		"two":   2,
		"three": 3,
	}

	// 获取值的切片
	values := make([]int, 0)
	for _, v := range testMap {
		values = append(values, v)
	}

	// 对值的切片排序
	sort.Ints(values)
	for _, v := range values {
		fmt.Println(v)
	}
}
