package main

import (
	"fmt"
	"strconv"
)

func solution(num int, data string) string {
	rCnt, lCnt := make([]int, num), make([]int, num) // rCnt[i] > 0, lCnt[j] < 0

	for i := 1; i < num; i++ {
		if (data[i-1] == 'R' && data[i] == '.') || (rCnt[i-1] > 0 && data[i] == '.') {
			rCnt[i] = rCnt[i-1] + 1
		}
	}
	for i := num - 2; i >= 0; i-- {
		if (data[i+1] == 'L' && data[i] == '.') || (lCnt[i+1] < 0 && data[i] == '.') {
			lCnt[i] = lCnt[i+1] - 1
		}
	}

	res, sum := "", 0
	for i := 0; i < num; i++ {
		if data[i] == '.' && rCnt[i]+lCnt[i] == 0 {
			if res != "" {
				res += ","
			}
			res += strconv.Itoa(i + 1)
			sum++
		}
	}

	if sum == 0 {
		return "0"
	}
	return strconv.Itoa(sum) + ":" + res
}

func main() {
	//  You can add more test cases here
	fmt.Println(solution(14, ".L.R...LR..L..") == "4:3,6,13,14")
	fmt.Println(solution(5, "R....") == "0")
	fmt.Println(solution(1, ".") == "1:1")
}
