<?php

class Solution {

    /**
     * @param Integer $m
     * @param Integer $n
     * @param Integer[][] $ops
     * @return Integer
     */
    function maxCount(int $m, int $n, array $ops): int {
        $mina = $m;
        $minb = $n;
        foreach ($ops as $op) {
            $mina = min($mina, $op[0]);
            $minb = min($minb, $op[1]);
        }
        return $mina * $minb;
    }
}

// test
echo new Solution()->maxCount(3, 3, [[2, 2], [3, 3]]);