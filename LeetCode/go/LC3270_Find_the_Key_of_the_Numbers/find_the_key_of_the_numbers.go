package find_the_key_of_the_numbers

func generateKey(num1 int, num2 int, num3 int) int {
	key := 0
	for p := 1; num1 > 0 && num2 > 0 && num3 > 0; p *= 10 {
		key += min(num1%10, num2%10, num3%10) * p
		num1 /= 10
		num2 /= 10
		num3 /= 10
	}
	return key
}
