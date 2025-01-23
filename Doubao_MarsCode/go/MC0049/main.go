package main

import (
	"fmt"
	"sort"
)

func solution(n int, s []string, x []int) []string {
	merged := make(map[string]int)
	orderMap := make(map[string]int)

	for i := 0; i < n; i++ {
		name := s[i]
		amount := x[i]

		merged[name] += amount

		if _, exists := orderMap[name]; !exists {
			orderMap[name] = i
		}
	}

	type NameAmount struct {
		Name   string
		Amount int
	}
	var entries []NameAmount

	for name, amount := range merged {
		entries = append(entries, NameAmount{name, amount})
	}

	sort.Slice(entries, func(i, j int) bool {
		if entries[i].Amount == entries[j].Amount {
			return orderMap[entries[i].Name] < orderMap[entries[j].Name]
		}
		return entries[i].Amount > entries[j].Amount
	})

	result := make([]string, len(entries))
	for i, entry := range entries {
		result[i] = entry.Name
	}

	return result
}

func main() {
	fmt.Println(sliceEqual(solution(4, []string{"a", "b", "c", "d"}, []int{1, 2, 2, 1}), []string{"b", "c", "a", "d"}))
	fmt.Println(sliceEqual(solution(3, []string{"x", "y", "z"}, []int{100, 200, 200}), []string{"y", "z", "x"}))
	fmt.Println(sliceEqual(solution(5, []string{"m", "n", "o", "p", "q"}, []int{50, 50, 30, 30, 20}), []string{"m", "n", "o", "p", "q"}))
}

func sliceEqual(a, b []string) bool {
	if len(a) != len(b) {
		return false
	}
	for i, v := range a {
		if v != b[i] {
			return false
		}
	}
	return true
}
