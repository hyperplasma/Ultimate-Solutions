package main

import "fmt"

func solution(n int, A int, B int, array_a []int) int {
	// 创建三维dp数组
	dp := make([][][]int, n+1)
	for i := range dp {
		dp[i] = make([][]int, 10)
		for j := range dp[i] {
			dp[i][j] = make([]int, 10)
		}
	}

	// 初始化dp数组
	dp[0][0][0] = 1
	sum := 0

	// 遍历每个数字
	for i := 1; i <= len(array_a); i++ {
		// 第一组
		for j := 0; j < 10; j++ {
			// 第二组
			for k := 0; k < 10; k++ {
				// 加入第一组
				// 注意：为了避免负数，我们需要确保结果为正
				prevJ := ((j + 10) - array_a[i-1]%10) % 10
				dp[i][j][k] += dp[i-1][prevJ][k]

				// 加入第二组
				prevK := ((k + 10) - array_a[i-1]%10) % 10
				dp[i][j][k] += dp[i-1][j][prevK]
			}
		}
		// 累加和
		sum += array_a[i-1]
	}

	// 检查总和的个位数是否为A或B
	a := 0
	if sum%10 == A {
		a = 1
	}

	b := 0
	if sum%10 == B {
		b = 1
	}

	return dp[n][A][B] + a + b
}

func main() {
	fmt.Println(solution(3, 1, 2, []int{1, 1, 1}) == 3)
	fmt.Println(solution(3, 3, 5, []int{1, 1, 1}) == 1)
	fmt.Println(solution(2, 1, 1, []int{1, 1}) == 2)
}
