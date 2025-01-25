<?php

class Solution {

    /**
     * @param Integer[][] $transactions
     * @return Integer
     */
    function minimumMoney(array $transactions): int {
        $total_lose = 0;
        $res = 0;
        foreach ($transactions as $t) {
            $cost = $t[0];
            $cashback = $t[1];
            $total_lose += max($cost - $cashback, 0);
            $res = max($res, min($cost, $cashback));
        }
        return $total_lose + $res;
    }
}

// test
echo new Solution()->minimumMoney([[2, 1], [3, 2], [10, 3]]);