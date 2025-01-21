package my_calender_iii

import "sort"

type MyCalendarThree struct {
	cnt map[int]int
}

func Constructor() MyCalendarThree {
	return MyCalendarThree{cnt: make(map[int]int)}
}

func (this *MyCalendarThree) Book(startTime int, endTime int) int {
	res := 0
	maxBook := 0
	this.cnt[startTime]++
	this.cnt[endTime]--

	keys := make([]int, 0, len(this.cnt))
	for key := range this.cnt {
		keys = append(keys, key)
	}
	sort.Ints(keys)

	for _, key := range keys {
		freq := this.cnt[key] // 以起点x开始的预定的总数目为 \Sum_{i \le x} cnt[i]
		maxBook += freq
		if maxBook > res {
			res = maxBook
		}
	}
	return res
}
