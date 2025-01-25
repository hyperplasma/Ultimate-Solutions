package main

import (
	"fmt"
	"sort"
)

func solution(inputArray [][]int) int {
	sort.Slice(inputArray, func(i, j int) bool {
		return inputArray[i][0] < inputArray[j][0]
	})

	start, end, cnt := 0, 0, 0
	for _, seg := range inputArray {
		if seg[0] > end {
			cnt += end - start + 1
			start = seg[0]
			end = seg[1]
		} else if seg[1] > end {
			end = seg[1]
		}
	}
	cnt += end - start
	return cnt
}

func main() {
	//  You can add more test cases here
	testArray1 := [][]int{{1, 4}, {7, 10}, {3, 5}}
	testArray2 := [][]int{{1, 2}, {6, 10}, {11, 15}}

	fmt.Println(solution(testArray1) == 9)
	fmt.Println(solution(testArray2) == 12)
}
