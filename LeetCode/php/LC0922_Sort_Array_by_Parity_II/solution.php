<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer[]
     */
    function sortArrayByParityII(array $nums): array {
        $n = count($nums);
        for ($i = 0, $j = 1; $i < $n; $i += 2) {
            if ($nums[$i] % 2 != 0) {
                while ($nums[$j] % 2 != 0) {
                    $j += 2;
                }
                $this->swap($nums, $i, $j);
            }
        }
        return $nums;
    }

    private function swap(&$nums, $i, $j): void {
        $temp = $nums[$i];
        $nums[$i] = $nums[$j];
        $nums[$j] = $temp;
    }
}

// test
echo json_encode(new Solution()->sortArrayByParityII([4, 2, 5, 7]));
echo "\n";
echo json_encode(new Solution()->sortArrayByParityII([2, 3]));