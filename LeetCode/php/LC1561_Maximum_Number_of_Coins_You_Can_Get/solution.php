<?php

class Solution {

    /**
     * @param Integer[] $piles
     * @return Integer
     */
    function maxCoins(array $piles): int {
        sort($piles);
        $sum = 0;
        for ($i = count($piles) / 3; $i < count($piles); $i += 2) {
            $sum += $piles[$i];
        }
        return $sum;
    }
}

// test
echo new Solution()->maxCoins([2, 4, 1, 2, 7, 8]);
