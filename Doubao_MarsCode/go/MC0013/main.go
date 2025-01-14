package main

import (
	"fmt"
	"reflect"
)

func solution(n int) []int {
	var list []int
	for i := 1; i <= n; i++ {
		for j := n; j >= i; j-- {
			list = append(list, j)
		}
	}
	return list
}

func main() {
	fmt.Println(reflect.DeepEqual(solution(3), []int{3, 2, 1, 3, 2, 3}))
	fmt.Println(reflect.DeepEqual(solution(4), []int{4, 3, 2, 1, 4, 3, 2, 4, 3, 4}))
	fmt.Println(reflect.DeepEqual(solution(5), []int{5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5}))
}
