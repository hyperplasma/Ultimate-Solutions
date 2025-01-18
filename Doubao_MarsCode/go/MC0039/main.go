package main

import (
	"fmt"
	"math"
)

func solution(x int, y int) int {
	dist := int(math.Abs(float64(x - y)))

	flag := 0
	length := 1
	steps := 0
	for dist > 0 {
		if flag == 2 {
			length++
			flag = 0
		}
		dist -= length
		flag++
		steps++
	}

	return steps
}

func main() {
	//  You can add more test cases here
	fmt.Println(solution(12, 6) == 4)
	fmt.Println(solution(34, 45) == 6)
	fmt.Println(solution(50, 30) == 8)
}
