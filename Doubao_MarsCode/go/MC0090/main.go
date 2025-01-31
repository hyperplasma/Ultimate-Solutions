package main

import "fmt"

func solution(V, W int) string {
	if V <= 5 {
		return "YES"
	}

	for W > 0 {
		remainder := W % V
		if remainder <= 2 {
			W /= V
		} else if remainder >= V-2 {
			W = W/V + 1
		} else {
			return "NO"
		}
	}

	return "YES"
}

func main() {
	// Add your test cases here
	fmt.Println(solution(10, 9) == "YES")
	fmt.Println(solution(200, 40199) == "YES")
	fmt.Println(solution(108, 50) == "NO")
}
