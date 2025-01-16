package main

import (
	"fmt"
)

func solution(a []int, b []int) []int {
	if len(a) == 0 || len(b) == 0 {
		return []int{}
	}

	m := make(map[int]int)
	for _, v := range a {
		m[v]++
	}

	res := make([]int, 0)
	for i := len(b) - 1; i >= 0; i-- {
		if m[b[i]] > 0 {
			res = append(res, b[i])
		}
	}
	return res
}

func main() {
	fmt.Println(equal(solution([]int{1, 2, 3, 7}, []int{2, 5, 7}), []int{7, 2}))
	fmt.Println(equal(solution([]int{1, 4, 8, 10}, []int{2, 4, 8, 10}), []int{10, 8, 4}))
	fmt.Println(equal(solution([]int{3, 5, 9}, []int{1, 4, 6}), []int{}))
	fmt.Println(equal(solution([]int{1, 2, 3}, []int{1, 2, 3}), []int{3, 2, 1}))
}

func equal(a, b []int) bool {
	if len(a) != len(b) {
		return false
	}
	for i := range a {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}
