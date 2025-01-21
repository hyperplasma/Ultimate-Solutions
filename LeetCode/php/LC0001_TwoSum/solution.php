<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum(array $nums, int $target): array {
        $map = array();
        for ($i = 0; $i < count($nums); $i++) {
            if (isset($map[$target - $nums[$i]])) {
                return [$i, $map[$target - $nums[$i]]];
            }
            $map[$nums[$i]] = $i;
        }
        return [0, 0];
    }
}

$nums = [2, 7, 11, 15];
$target = 9;
$result = new Solution()->twoSum($nums, $target);
echo implode(",", $result);