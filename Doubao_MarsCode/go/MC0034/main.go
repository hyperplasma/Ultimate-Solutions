package main

import "fmt"

func solution(n int, nums []int) int {
	max1, max2, max3 := 0, 0, 0
	for _, num := range nums {
		if num > max1 {
			max3 = max2
			max2 = max1
			max1 = num
		} else if num > max2 && num != max1 {
			max3 = max2
			max2 = num
		} else if num > max3 && num != max2 {
			max3 = num
		}
	}

	if max3 == 0 {
		return max1
	}
	return max3
}

func main() {
	fmt.Println(solution(3, []int{3, 2, 1}) == 1)
	fmt.Println(solution(2, []int{1, 2}) == 2)
	fmt.Println(solution(4, []int{2, 2, 3, 1}) == 1)
}
