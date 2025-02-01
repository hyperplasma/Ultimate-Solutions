<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search(array $nums, int $target): int {
        $n = count($nums);
        if ($n == 0) {
            return -1;
        }
        if ($n == 1) {
            return $nums[0] == $target ? 0 : -1;
        }

        $l = 0;
        $r = $n - 1;
        while ($l <= $r) {
            $mid = $l + floor(($r - $l) / 2);
            if ($nums[$mid] == $target) {
                return $mid;
            }

            if ($nums[$l] <= $nums[$mid]) { // left sorted
                if ($nums[$l] <= $target && $target < $nums[$mid]) {
                    $r = $mid - 1;
                } else {
                    $l = $mid + 1;
                }
            } else {    // right sorted
                if ($nums[$mid] < $target && $target <= $nums[$r]) {
                    $l = $mid + 1;
                } else {
                    $r = $mid - 1;
                }
            }
        }

        return -1;
    }
}

// test
echo new Solution()->search([4,5,6,7,0,1,2], 0);
echo new Solution()->search([4,5,6,7,0,1,2], 3);
echo new Solution()->search([1], 0);