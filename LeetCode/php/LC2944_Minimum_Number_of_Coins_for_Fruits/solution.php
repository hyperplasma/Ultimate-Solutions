<?php

class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function minimumCoins(array $prices): int {
        $n = count($prices);
        $queue = [];
        array_push($queue, [$n, 0]);
        for ($i = $n - 1; $i >= 0; $i--) {
            while (end($queue)[0] >= 2 * $i + 3) {
                array_pop($queue);
            }
            $cur = end($queue)[1] + $prices[$i];
            while (reset($queue)[1] >= $cur) {
                array_shift($queue);
            }
            array_unshift($queue, [$i, $cur]);
        }
        return reset($queue)[1];
    }
}

// test
echo new Solution()->minimumCoins([26, 18, 6, 12, 49, 7, 45, 45]);