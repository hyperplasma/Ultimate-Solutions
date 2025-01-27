package main

import "fmt"

func solution(plates []int, n int) string {
	res := ""
	for i := 0; i < n; i++ {
		j := i
		for i+1 < n && plates[i+1]-plates[i] == 1 {
			i++
		}
		if i-j+1 >= 3 {
			res += fmt.Sprintf("%d-%d,", plates[j], plates[i])
		} else if i-j+1 == 2 {
			res += fmt.Sprintf("%d,%d,", plates[j], plates[j+1])
		} else {
			res += fmt.Sprintf("%d,", plates[j])
		}
	}
	return res[:len(res)-1]
}

func main() {
	//  You can add more test cases here
	fmt.Println(solution([]int{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20}, 10) == "-3--1,2,10,15,16,18-20")
	fmt.Println(solution([]int{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}, 20) == "-6,-3-1,3-5,7-11,14,15,17-20")
	fmt.Println(solution([]int{1, 2, 7, 8, 9, 10, 11, 19}, 8) == "1,2,7-11,19")
}
