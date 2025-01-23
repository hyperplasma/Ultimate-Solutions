package sort

import (
	"fmt"
	"sort"
)

// 示例：按键排序
func sortByKey() {
	testMap := map[string]int{
		"one":   1,
		"two":   2,
		"three": 3,
	}

	// 获取键的切片
	keys := make([]string, 0)
	for k := range testMap {
		keys = append(keys, k)
	}

	// 对键的切片排序
	sort.Strings(keys)
	for _, v := range keys {
		fmt.Println(v, testMap[v])
	}
}
