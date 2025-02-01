<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Boolean
     */
    function search(array $nums, int $target): bool {
        $n = count($nums);
        if ($n == 0) {
            return false;
        }
        if ($n == 1) {
            return $nums[0] == $target;
        }

        $l = 0;
        $r = $n - 1;
        while ($l <= $r) {
            $mid = floor(($l + $r) / 2);
            if ($nums[$mid] == $target) {
                return true;
            }

            if ($nums[$l] == $nums[$mid] && $nums[$mid] == $nums[$r]) {
                $l++;
                $r--;
            } else if ($nums[$l] <= $nums[$mid]) {
                if ($nums[$l] <= $target && $target < $nums[$mid]) {
                    $r = $mid - 1;
                } else {
                    $l = $mid + 1;
                }
            } else {
                if ($nums[$mid] < $target && $target <= $nums[$r]) {
                    $l = $mid + 1;
                } else {
                    $r = $mid - 1;
                }
            }
        }

        return false;
    }
}

// test
echo new Solution()->search([2, 5, 6, 0, 0, 1, 2], 0);
echo new Solution()->search([2, 5, 6, 0, 0, 1, 2], 3);