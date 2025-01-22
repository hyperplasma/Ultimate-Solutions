package main

import (
	"fmt"
	"strings"
)

func solution(s string) string {
	return strings.ReplaceAll(s, "a", "%100")
}

func main() {
	fmt.Println(solution("abcdwa") == "%100bcdw%100")
	fmt.Println(solution("banana") == "b%100n%100n%100")
	fmt.Println(solution("apple") == "%100pple")
}
