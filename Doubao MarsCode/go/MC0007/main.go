package main

import (
	"fmt"
	"regexp"
	"strings"
)

func solution(n int, template_ string, titles []string) string {
	// 将模板中的通配符部分转换为正则表达式
	regex := regexp.MustCompile(`\{[^}]*\}`).ReplaceAllString(template_, ".*")

	// 遍历每个标题并进行匹配
	var results []string
	for _, title := range titles {
		matched, _ := regexp.MatchString("^"+regex+"$", title)
		if matched {
			results = append(results, "True")
		} else {
			results = append(results, "False")
		}
	}

	return strings.Join(results, ",")
}

func main() {
	// You can add more test cases here
	testTitles1 := []string{"adcdcefdfeffe", "adcdcefdfeff", "dcdcefdfeffe", "adcdcfe"}
	testTitles2 := []string{"CLSomGhcQNvFuzENTAMLCqxBdj", "CLSomNvFuXTASzENTAMLCqxBdj", "CLSomFuXTASzExBdj", "CLSoQNvFuMLCqxBdj", "SovFuXTASzENTAMLCq", "mGhcQNvFuXTASzENTAMLCqx"}
	testTitles3 := []string{"abcdefg", "abefg", "efg"}

	fmt.Println(solution(4, "ad{xyz}cdc{y}f{x}e", testTitles1) == "True,False,False,True")
	fmt.Println(solution(6, "{xxx}h{cQ}N{vF}u{XTA}S{NTA}MLCq{yyy}", testTitles2) == "False,False,False,False,False,True")
	fmt.Println(solution(3, "a{bdc}efg", testTitles3) == "True,True,False")
}
