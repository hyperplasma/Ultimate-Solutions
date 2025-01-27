<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function jump(array $nums): int {
        $length = count($nums);
        $end = 0;
        $maxPos = 0;
        $steps = 0;
        for ($i = 0; $i < $length - 1; $i++) {
            $maxPos = max($maxPos, $i + $nums[$i]);
            if ($i == $end) {
                $end = $maxPos;
                $steps++;
            }
        }
        return $steps;
    }
}

// test
echo new Solution()->jump([2, 3, 1, 1, 4]);