package main

import "fmt"

func solution(x int, y int) int {
	for i := 1; i <= 10; i++ {
		if x*x+y*y <= i*i {
			return 11 - i
		}
	}
	return 0
}

func main() {
	fmt.Println(solution(1, 0) == 10)
	fmt.Println(solution(1, 1) == 9)
	fmt.Println(solution(0, 5) == 6)
	fmt.Println(solution(3, 4) == 6)
}
