package spiral_matrix_ii

func generateMatrix(n int) [][]int {
	res := make([][]int, n)
	for i := 0; i < n; i++ {
		res[i] = make([]int, n)
	}
	cur := 1

	i, j := 0, 0
	for cur <= n*n {
		for j < n && res[i][j] == 0 {
			res[i][j] = cur
			cur++
			j++
		}
		j--
		i++
		for i < n && res[i][j] == 0 {
			res[i][j] = cur
			cur++
			i++
		}
		i--
		j--
		for j >= 0 && res[i][j] == 0 {
			res[i][j] = cur
			cur++
			j--
		}
		j++
		i--
		for i >= 0 && res[i][j] == 0 {
			res[i][j] = cur
			cur++
			i--
		}
		i++
		j++
	}
	return res
}
