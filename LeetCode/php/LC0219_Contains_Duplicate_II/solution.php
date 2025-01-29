<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return Boolean
     */
    function containsNearbyDuplicate(array $nums, int $k): bool {
        $map = [];
        foreach ($nums as $i => $v) {
            if (isset($map[$v]) && $i - $map[$v] <= $k) {
                return true;
            }
            $map[$v] = $i;
        }
        return false;
    }
}

// test
echo json_encode(new Solution()->containsNearbyDuplicate([1, 2, 3, 1], 3));