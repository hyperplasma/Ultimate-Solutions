package main

import (
	"fmt"
	"strconv"
	"strings"
)

const base32Chars = "9876543210mnbvcxzasdfghjklpoiuyt"

var base32Map = make(map[rune]int)

func init() {
	for i, c := range base32Chars {
		base32Map[c] = i
	}
}

// Base32 编码
func encodeBase32(rawStr string) string {
	var binaryBuilder strings.Builder
	for _, c := range rawStr {
		binaryStr := fmt.Sprintf("%08b", c)
		binaryBuilder.WriteString(binaryStr)
	}
	// 补齐到5的倍数
	for binaryBuilder.Len()%5 != 0 {
		binaryBuilder.WriteByte('0')
	}

	var encoded strings.Builder
	for i := 0; i < binaryBuilder.Len(); i += 5 {
		group := binaryBuilder.String()[i : i+5]
		index, _ := strconv.ParseInt(group, 2, 64)
		encoded.WriteRune(rune(base32Chars[index]))
	}

	// 添加填充字符
	paddingCount := (8 - (encoded.Len() % 8)) % 8
	encoded.WriteString(strings.Repeat("+", paddingCount))

	return encoded.String()
}

// Base32 解码
func decodeBase32(encodedStr string) string {
	split := strings.Split(encodedStr, "+")
	var decoded strings.Builder
	for _, s := range split {
		if s == "" {
			continue
		}
		var binaryBuilder strings.Builder
		for _, c := range s {
			index := base32Map[c]
			binaryStr := fmt.Sprintf("%05b", index)
			binaryBuilder.WriteString(binaryStr)
		}
		for i := 0; i < binaryBuilder.Len(); i += 8 {
			if i+8 > binaryBuilder.Len() {
				break
			}
			byteStr := binaryBuilder.String()[i : i+8]
			ascii, _ := strconv.ParseInt(byteStr, 2, 64)
			decoded.WriteRune(rune(ascii))
		}
	}
	return decoded.String()
}

func solution(rawStr, encodedStr string) string {
	encoded := encodeBase32(rawStr)
	decoded := decodeBase32(encodedStr)
	return encoded + ":" + decoded
}

func main() {
	fmt.Println(solution("foo", "b0zj5+++") == "bljhy+++:bar")
	fmt.Println(solution("The encoding process", "bljhy+++b0zj5+++") == "maf3m164vlahyl60vlds9i6svuahmiod:foobar")
	fmt.Println(solution("Base32 encoding and decoding", "bvchz+++v4j21+++cals9+++") == "10zj3l0d31z3mod6vus3sod258zhil89bash3oo5v4j3c+++:c]hintts ")
}
