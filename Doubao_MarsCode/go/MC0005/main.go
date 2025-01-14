package main

import (
	"fmt"
	"sort"
)

func solution(n int, max int, array []int) [2]int {
	m := make(map[int]int)
	for _, v := range array {
		if v == 1 {
			v = 14
		}
		m[v]++
	}

	// 将map的键和值复制到slice，根据键进行从大到小排序，再重新构造成map
	var keys []int
	for k := range m {
		keys = append(keys, k)
	}
	sort.Slice(keys, func(i, j int) bool {
		return keys[i] > keys[j]
	})
	sortedMap := make(map[int]int)
	for _, k := range keys {
		sortedMap[k] = m[k]
	}

	for card1, cnt1 := range sortedMap {
		if cnt1 >= 3 {
			for card2, cnt2 := range sortedMap {
				if card1 != card2 && cnt2 >= 2 {
					res1 := card1
					if card1 == 14 {
						res1 = 1
					}
					res2 := card2
					if card2 == 14 {
						res2 = 1
					}

					if 3*res1+2*res2 <= max {
						return [2]int{res1, res2}
					}
				}
			}
		}
	}

	return [2]int{0, 0}
}

func main() {
	// Add your test cases here

	fmt.Println(solution(9, 34, []int{6, 6, 6, 8, 8, 8, 5, 5, 1}) == [2]int{8, 5})
	fmt.Println(solution(9, 37, []int{9, 9, 9, 9, 6, 6, 6, 6, 13}) == [2]int{6, 9})
	fmt.Println(solution(9, 40, []int{1, 11, 13, 12, 7, 8, 11, 5, 6}) == [2]int{0, 0})
}
