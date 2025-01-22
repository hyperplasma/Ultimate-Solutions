package LC1561_Maximum_Number_of_Coins_You_Can_Get

import "sort"

func maxCoins(piles []int) int {
	sort.Ints(piles)
	sum := 0
	for i := len(piles) / 3; i < len(piles); i += 2 {
		sum += piles[i]
	}
	return sum
}
