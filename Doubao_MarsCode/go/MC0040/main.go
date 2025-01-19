package main

import "fmt"

func solution(dnaSeq string) string {
	minSeq := dnaSeq
	for i := 1; i < len(dnaSeq); i++ {
		curSeq := dnaSeq[i:] + dnaSeq[:i]
		if curSeq < minSeq {
			minSeq = curSeq
		}
	}
	return minSeq
}

func main() {
	// You can add more test cases here
	fmt.Println(solution("ATCA") == "AATC")
	fmt.Println(solution("CGAGTC") == "AGTCCG")
	fmt.Println(solution("TCATGGAGTGCTCCTGGAGGCTGAGTCCATCTCCAGTAG") == "AGGCTGAGTCCATCTCCAGTAGTCATGGAGTGCTCCTGG")
}
