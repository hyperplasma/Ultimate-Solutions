package main

import (
	"fmt"
	"math"
	"sort"
)

func solution(n int, m int, k int, a []int, b []int) int {
	sort.Ints(a)
	sort.Ints(b)

	minDiff := int(^uint(0) >> 1)
	i, j := 0, 0
	for i < n && j < m {
		diff := int(math.Abs(float64((a[i]-b[j])*(a[i]-b[j]) - k*k)))
		minDiff = min(minDiff, diff)
		if a[i] < b[j] {
			i++
		} else {
			j++
		}
	}

	return minDiff
}

func main() {
	// You can add more test cases here
	fmt.Println(solution(5, 5, 1, []int{5, 3, 4, 1, 2}, []int{0, 6, 7, 9, 8}) == 0)
	fmt.Println(solution(5, 5, 0, []int{5, 3, 4, 1, 2}, []int{0, 6, 7, 9, 8}) == 1)
	fmt.Println(solution(5, 6, 3, []int{5, 3, 4, 1, 2}, []int{0, 6, 7, 9, 8, 11}) == 0)
}
