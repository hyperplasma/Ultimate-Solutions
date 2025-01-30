package main

import "fmt"

func solution(n int, b int, sequence []int) int {
	res := 0
	prefixSum := 0
	count := make(map[int]int)

	for _, num := range sequence {
		prefixSum += num
		mod := prefixSum % b

		if mod == 0 {
			res++
		}

		if count[mod] > 0 {
			res += count[mod]
		}

		count[mod]++
	}

	return res
}

func main() {
	// You can add more test cases here
	fmt.Println(solution(3, 3, []int{1, 2, 3}) == 3)
	fmt.Println(solution(5, 2, []int{1, 2, 3, 4, 5}) == 6)
}
