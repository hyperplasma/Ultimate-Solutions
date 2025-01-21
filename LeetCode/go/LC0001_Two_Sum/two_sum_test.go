package two_sum

import (
	"fmt"
	"testing"
)

func Test_twoSum(t *testing.T) {
	arr := []int{2, 7, 11, 15}
	res := twoSum(arr, 9)
	fmt.Println(res)
}
