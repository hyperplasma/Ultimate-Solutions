package main

import (
	"fmt"
	"strings"
)

func solution(s string) string {
	// 去除前导零
	s = strings.TrimLeft(s, "0")
	if s == "" {
		s = "0"
	}

	// 分离整数和小数部分
	parts := strings.Split(s, ".")
	integerPart := parts[0]
	decimalPart := ""
	if len(parts) > 1 {
		decimalPart = "." + parts[1]
	}

	// 格式化整数部分
	var formattedInteger strings.Builder
	count := 0
	for i := len(integerPart) - 1; i >= 0; i-- {
		formattedInteger.WriteByte(integerPart[i])
		count++
		if count%3 == 0 && i != 0 {
			formattedInteger.WriteByte(',')
		}
	}

	// 反转格式化的整数部分
	runes := []rune(formattedInteger.String())
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}

	return string(runes) + decimalPart
}

func main() {
	fmt.Println(solution("1294512.12412") == "1,294,512.12412")
	fmt.Println(solution("0000123456789.99") == "123,456,789.99")
	fmt.Println(solution("987654321") == "987,654,321")
}
