package main

import (
	"fmt"
	"math"
)

func solution(m int, n int, p [][]int) int {
	dp := make([]int, m+1)
	for i := 0; i <= m; i++ {
		dp[i] = math.MaxInt32
	}
	dp[0] = 0

	for _, station := range p {
		day := station[0]
		cost := station[1]
		for j := day; j <= m; j++ {
			if dp[day] != math.MaxInt32 {
				dp[j] = min(dp[j], dp[day]+(j-day)*cost)
			}
		}
	}

	return dp[m]
}

func main() {
	// Add your test cases here

	fmt.Println(solution(5, 4, [][]int{{0, 2}, {1, 3}, {2, 1}, {3, 2}}) == 7)
}
