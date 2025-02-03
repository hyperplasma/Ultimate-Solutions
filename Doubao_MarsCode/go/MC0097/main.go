package main

import "fmt"

func solution(n int, arr []int) string {
	maxProd := 0.0
	start, end := -1, -1

	for i := 0; i < n; i++ {
		if arr[i] == 0 {
			continue
		}

		prod := 1.0
		for j := i; j < n; j++ {
			if arr[j] == 0 {
				break
			}

			prod *= float64(arr[j])
			if prod > maxProd {
				maxProd = prod
				start = i
				end = j
			} else if i < start || (i == start && j < end) {
				start = i
				end = j
			}
		}
	}

	if start == -1 || end == -1 {
		return "1,1"
	}
	return fmt.Sprintf("%d,%d", start+1, end+1)
}

func main() {
	// Add your test cases here
	fmt.Println(solution(5, []int{1, 2, 4, 0, 8}) == "1,3")
	fmt.Println(solution(7, []int{1, 2, 4, 8, 0, 256, 0}) == "6,6")
}
