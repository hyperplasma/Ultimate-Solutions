package maximum_consecutive_floors_without_special_floors

import (
	"fmt"
	"testing"
)

func Test_maxConsecutive(t *testing.T) {
	special := []int{1, 2, 7, 8, 9}
	fmt.Println(maxConsecutive(1, 9, special))
}
