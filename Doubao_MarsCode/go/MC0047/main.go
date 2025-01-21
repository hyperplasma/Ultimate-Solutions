package main

import "fmt"

func solution(n int, l int, r int, a []int) int {
	cnt := 0
	for _, num := range a {
		if num%2 == 0 && num >= l && num <= r {
			cnt++
		}
	}
	return cnt
}

func main() {
	fmt.Println(solution(5, 3, 8, []int{1, 2, 6, 8, 7}) == 2)
	fmt.Println(solution(4, 10, 20, []int{12, 15, 18, 9}) == 2)
	fmt.Println(solution(3, 1, 10, []int{2, 4, 6}) == 3)
}
