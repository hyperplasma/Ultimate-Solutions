package my_calender_iii

import "sort"

type MyCalendarThree struct {
	cnt map[int]int
}

func Constructor() MyCalendarThree {
	return MyCalendarThree{cnt: make(map[int]int)}
}

func (t *MyCalendarThree) Book(startTime int, endTime int) int {
	res := 0
	maxBook := 0
	t.cnt[startTime]++
	t.cnt[endTime]--

	keys := make([]int, 0, len(t.cnt))
	for key := range t.cnt {
		keys = append(keys, key)
	}
	sort.Ints(keys)

	for _, key := range keys {
		freq := t.cnt[key] // 以起点x开始的预定的总数目为 \Sum_{i \le x} cnt[i]
		maxBook += freq
		if maxBook > res {
			res = maxBook
		}
	}
	return res
}
