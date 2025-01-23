package maximum_points_after_collecting_coins_from_all_nodes

import (
	"fmt"
	"testing"
)

func Test_maximumPoints(t *testing.T) {
	fmt.Println(maximumPoints([][]int{{0, 1}, {1, 2}, {2, 3}}, []int{10, 10, 3, 3}, 5))
}
