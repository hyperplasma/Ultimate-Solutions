package minimum_operations_to_make_columns_strictly_increasing

func minimumOperations(grid [][]int) int {
	counter := 0
	for i := 0; i < len(grid[0]); i++ {
		for j := 0; j < len(grid)-1; j++ {
			delta := grid[j+1][i] - grid[j][i]
			if delta <= 0 {
				grid[j][i] += -delta + 1
				counter += -delta + 1
			}
		}
	}
	return counter
}
