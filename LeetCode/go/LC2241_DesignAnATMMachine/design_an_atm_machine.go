package design_an_atm_machine

type ATM struct {
	cnt   []int
	value []int
}

func Constructor() ATM {
	return ATM{cnt: []int{0, 0, 0, 0, 0}, value: []int{20, 50, 100, 200, 500}}
}

func (this *ATM) Deposit(banknotesCount []int) {
	for i, v := range banknotesCount {
		this.cnt[i] += v
	}
}

func (this *ATM) Withdraw(amount int) []int {
	res := make([]int, 5)
	for i := 4; i >= 0; i-- {
		if amount >= this.value[i] && this.cnt[i] > 0 {
			res[i] = min(this.cnt[i], amount/this.value[i])
			amount -= res[i] * this.value[i]
		} else {
			res[i] = 0
		}
	}
	if amount > 0 {
		return []int{-1}
	} else {
		for i, v := range res {
			this.cnt[i] -= v
		}
		return res
	}
}
