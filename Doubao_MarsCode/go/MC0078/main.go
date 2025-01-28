package main

import "fmt"

func solution(nums []int) string {
	cnt := make(map[int]int)
	for _, num := range nums {
		cnt[num]++
	}

	for _, v := range cnt {
		if v%5 != 0 {
			return "False"
		}
	}
	return "True"
}

func main() {
	// You can add more test cases here
	fmt.Println(solution([]int{1, 3, 4, 5, 6, 5, 4}) == "False")
	fmt.Println(solution([]int{1, 1, 1, 1, 2, 1, 2, 2, 2, 2}) == "True")
	fmt.Println(solution([]int{11, 45, 49, 37, 45, 38, 3, 47, 35, 49, 26, 16, 24, 4, 45, 39, 28, 26, 14, 22, 4, 49, 18, 4, 4, 26, 47, 14, 1, 21, 9, 26, 17, 12, 44, 28, 24, 24, 10, 31, 33, 32, 23, 41, 41, 19, 17, 24, 28, 46, 28, 4, 18, 23, 48, 45, 7, 21, 12, 40, 2, 19, 19, 28, 32, 6, 27, 43, 6, 18, 8, 27, 9, 6, 6, 31, 37, 15, 26, 20, 43, 3, 14, 40, 20}) == "False")
}
