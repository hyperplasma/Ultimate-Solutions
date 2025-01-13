package main

import "fmt"

// 定义方向数组，用于上下左右移动
var dx = []int{-1, 1, 0, 0} // 上下左右移动的行偏移
var dy = []int{0, 0, -1, 1} // 上下左右移动的列偏移

// Position 表示位置的结构体
type Position struct {
	x, y int
}

func solution(N, M int, data [][]rune) int {
	// 创建visited数组来标记可到达出口的位置
	canReachExit := make([][]bool, N)
	for i := range canReachExit {
		canReachExit[i] = make([]bool, M)
	}

	// 找到出口位置
	var exitX, exitY int
	for i := 0; i < N; i++ {
		for j := 0; j < M; j++ {
			if data[i][j] == 'O' {
				exitX, exitY = i, j
				goto Found
			}
		}
	}
Found:

	// 使用queue进行BFS
	queue := []Position{{exitX, exitY}}
	canReachExit[exitX][exitY] = true

	for len(queue) > 0 {
		// 出队
		curr := queue[0]
		queue = queue[1:]

		// 检查所有可能到达当前位置的点
		for i := 0; i < N; i++ {
			for j := 0; j < M; j++ {
				if canReachExit[i][j] {
					continue
				}

				// 检查从位置(i,j)是否可以到达当前位置
				if canMove(i, j, curr.x, curr.y, data, N, M) {
					canReachExit[i][j] = true
					queue = append(queue, Position{i, j})
				}
			}
		}
	}

	// 统计所有无法到达出口的位置数量
	dangerousCount := 0
	for i := 0; i < N; i++ {
		for j := 0; j < M; j++ {
			if !canReachExit[i][j] {
				dangerousCount++
			}
		}
	}

	return dangerousCount
}

// canMove 检查从(fromX, fromY)是否可以移动到(toX, toY)
func canMove(fromX, fromY, toX, toY int, data [][]rune, N, M int) bool {
	cell := data[fromX][fromY]

	// 检查传送器
	switch cell {
	case 'U':
		return fromX > 0 && fromX-1 == toX && fromY == toY
	case 'D':
		return fromX < N-1 && fromX+1 == toX && fromY == toY
	case 'L':
		return fromY > 0 && fromX == toX && fromY-1 == toY
	case 'R':
		return fromY < M-1 && fromX == toX && fromY+1 == toY
	case '.':
		// 检查普通地板的四个方向
		for i := 0; i < 4; i++ {
			nextX := fromX + dx[i]
			nextY := fromY + dy[i]
			if nextX == toX && nextY == toY &&
				nextX >= 0 && nextX < N && nextY >= 0 && nextY < M {
				return true
			}
		}
	}

	return false
}

func main() {
	// 测试用例1
	pattern1 := [][]rune{
		{'.', '.', '.', '.', '.'},
		{'.', 'R', 'R', 'D', '.'},
		{'.', 'U', '.', 'D', 'R'},
		{'.', 'U', 'L', 'L', '.'},
		{'.', '.', '.', '.', 'O'},
	}
	fmt.Printf("Test case 1: %v\n", solution(5, 5, pattern1) == 10)

	// 测试用例2
	pattern2 := [][]rune{
		{'.', 'R', '.', 'O'},
		{'U', '.', 'L', '.'},
		{'.', 'D', '.', '.'},
		{'.', '.', 'R', 'D'},
	}
	fmt.Printf("Test case 2: %v\n", solution(4, 4, pattern2) == 2)

	// 测试用例3
	pattern3 := [][]rune{
		{'.', 'U', 'O'},
		{'L', '.', 'R'},
		{'D', '.', '.'},
	}
	fmt.Printf("Test case 3: %v\n", solution(3, 3, pattern3) == 8)

	// 测试用例4
	pattern4 := [][]rune{
		{'.', 'R', '.', 'O'},
		{'U', '.', 'L', '.'},
		{'.', 'D', '.', '.'},
		{'.', '.', 'R', 'D'},
	}
	fmt.Printf("Test case 4: %v\n", solution(4, 4, pattern4) == 2)
}
