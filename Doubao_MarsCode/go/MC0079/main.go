package main

import "fmt"

func solution(N int, data_array []int) int {
	res := check(data_array)
	for i := 0; i < N; i++ {
		for j := i + 1; j < N; j++ {
			res = max(res, check(reverse(data_array, i, j)))
		}
	}
	return res
}

func reverse(a []int, start, end int) []int {
	res := make([]int, len(a))
	copy(res, a)
	for start < end {
		temp := res[start]
		res[start] = res[end]
		res[end] = temp
		end--
		start++
	}
	return res
}

func check(a []int) int {
	maxSum := a[0]
	curSum := a[0]
	for i := 1; i < len(a); i++ {
		curSum = max(a[i], curSum+a[i])
		maxSum = max(maxSum, curSum)
	}
	return maxSum
}

func main() {
	// You can add more test cases here
	array1 := []int{-85, -11, 92, 6, 49, -76, 28, -16, 3, -29, 26, 37, 86, 3, 25, -43, -36, -27, 45, 87, 91, 58, -15, 91, 5, 99, 40, 68, 54, -95, 66, 49, 74, 9, 24, -84, 12, -23, -92, -47, 5, 91, -79, 94, 61, -54, -71, -36, 31, 97, 64, -14, -16, 48, -79, -70, 54, -94, 48, 37, 47, -58, 6, 62, 19, 8, 32, 65, -81, -27, 14, -18, -34, -64, -97, -21, -76, 51, 0, -79, -22, -78, -95, -90, 4, 82, -79, -85, -64, -79, 63, 49, 21, 97, 47, 16, 61, -46, 54, 44}
	fmt.Println(solution(5, []int{1, 2, 3, -1, 4}) == 10)
	fmt.Println(solution(100, array1) == 1348)
}
