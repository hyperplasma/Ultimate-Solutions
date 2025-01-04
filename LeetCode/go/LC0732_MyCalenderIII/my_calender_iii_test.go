package my_calender_iii

import (
	"fmt"
	"testing"
)

func TestMyCalendarThree_Book(t *testing.T) {
	cal := Constructor()
	fmt.Println(cal.Book(10, 20))
	fmt.Println(cal.Book(50, 60))
	fmt.Println(cal.Book(10, 40))
	fmt.Println(cal.Book(5, 15))
}
