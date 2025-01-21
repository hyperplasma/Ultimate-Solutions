package minimum_operations_to_make_columns_strictly_increasing

import (
	"fmt"
	"testing"
)

func Test_minimumOperations(t *testing.T) {
	arr := [][]int{{2, 3}, {1, 4}}
	fmt.Println(minimumOperations(arr))
}
