package main

import (
	"fmt"
	"sort"
)

func solution(A []int) int {
	n := len(A)
	sorted := make([]int, n)
	copy(sorted, A)
	sort.Ints(sorted)

	cnt := 0
	for _, j := range A {
		numLessOrEqual := countLessOrEqual(sorted, j)
		numGreater := n - numLessOrEqual
		if numLessOrEqual > numGreater {
			cnt++
		}
	}
	return cnt
}

func countLessOrEqual(sorted []int, target int) int {
	low, high := 0, len(sorted)-1
	for low <= high {
		mid := (low + high) / 2
		if sorted[mid] <= target {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return low // low指向第一个大于target的位置，因此小于等于target的数量是low
}

func main() {
	// Add your test cases here
	fmt.Println(solution([]int{100, 100, 100}) == 3)
	fmt.Println(solution([]int{2, 1, 3}) == 2)
	fmt.Println(solution([]int{30, 1, 30, 30}) == 3)
	fmt.Println(solution([]int{19, 27, 73, 55, 88}) == 3)
	fmt.Println(solution([]int{19, 27, 73, 55, 88, 88, 2, 17, 22}) == 5)
}
