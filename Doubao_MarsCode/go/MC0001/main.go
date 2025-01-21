package main

import "fmt"

func solution(cards []int) int {
	const n = 1010
	cnt := make([]int, n)

	for _, card := range cards {
		cnt[card]++
	}

	res := -1
	for _, card := range cards {
		if cnt[card] == 1 {
			res = card
			break
		}
	}

	return res
}

func main() {
	// Add your test cases here

	fmt.Println(solution([]int{1, 1, 2, 2, 3, 3, 4, 5, 5}) == 4)
	fmt.Println(solution([]int{0, 1, 0, 1, 2}) == 2)
}
