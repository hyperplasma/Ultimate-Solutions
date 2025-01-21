<?php

class Solution {

    /**
     * @param Integer[][] $piles
     * @param Integer $k
     * @return Integer
     */
    function maxValueOfCoins(array $piles, int $k): int {
        $f = array_fill(0, $k + 1, -1);
        $f[0] = 0;
        foreach ($piles as $pile) {
            for ($i = $k; $i > 0; --$i) {
                $value = 0;
                for ($t = 1; $t <= count($pile); ++$t) {
                    $value += $pile[$t - 1];
                    if ($i >= $t && $f[$i - $t] != -1) {
                        $f[$i] = max($f[$i], $f[$i - $t] + $value);
                    }
                }
            }
        }
        return $f[$k];
    }
}

$piles = [[1, 100, 3], [7, 8, 9]];
$k = 2;
echo new Solution()->maxValueOfCoins($piles, $k);