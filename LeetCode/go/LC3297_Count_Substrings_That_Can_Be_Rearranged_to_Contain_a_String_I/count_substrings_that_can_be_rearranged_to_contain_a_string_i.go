package count_substrings_that_can_be_rearranged_to_contain_a_string_i

func validSubstringCount(word1 string, word2 string) int64 {
	cnt := make([]int, 26)
	diff := 0
	for _, c := range word2 {
		index := c - 'a'
		if cnt[index] == 0 {
			diff++
		}
		cnt[index]++
	}

	var res int64 = 0
	for left, right := 0, 0; right < len(word1); right++ {
		push := word1[right] - 'a'
		cnt[push]--
		if cnt[push] == 0 {
			diff--
		}
		for diff == 0 {
			pop := word1[left] - 'a'
			left++
			if cnt[pop] == 0 {
				diff++
			}
			cnt[pop]++
		}
		res += int64(left)
	}

	return res
}
