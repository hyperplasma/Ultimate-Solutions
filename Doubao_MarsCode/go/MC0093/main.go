package main

import (
	"fmt"
	"math"
)

func solution(n, k int, b, c []int) int {
	dp := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]int, k+1)
	}
	step := make([]int, n+1)

	for i := 1; i <= n; i++ {
		var a float64 = 1
		x := 1
		for a != float64(b[i-1]) {
			if a+math.Floor(a/float64(x)) <= float64(b[i-1]) {
				step[i]++
				a = a + math.Floor(a/float64(x))
			} else if a+math.Floor(a/float64(x)) > float64(b[i-1]) {
				x++
			}
		}
	}

	for i := 0; i <= k; i++ {
		dp[0][i] = 0
	}
	for i := 1; i <= n; i++ {
		if step[i] == 0 {
			dp[i][0] = c[i-1] + dp[i-1][0]
		} else {
			dp[i][0] = dp[i-1][0]
		}
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= k; j++ {
			if j < step[i] {
				dp[i][j] = dp[i-1][j]
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i-1][j-step[i]]+c[i-1])
			}
		}
	}

	return dp[n][k]
}

func main() {
	// Add your test cases here
	fmt.Println(solution(4, 4, []int{1, 7, 5, 2}, []int{2, 6, 5, 2}) == 9)
	fmt.Println(solution(3, 0, []int{3, 5, 2}, []int{5, 4, 7}) == 0)
}
