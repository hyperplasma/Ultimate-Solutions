<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function permuteUnique(array $nums): array {
        $res = [];
        $path = [];
        $n = count($nums);
        $visited = array_fill(0, $n, false);

        sort($nums);
        $this->backtrack(0, $nums, $path, $visited, $res);
        return $res;
    }

    private function backtrack($cur, $nums, $path, $visited, &$res): void {
        $n = count($nums);
        if ($cur === $n) {
            $res[] = $path;
            return;
        }

        for ($i = 0; $i < $n; $i++) {
            if ($visited[$i] || ($i > 0 && $nums[$i] === $nums[$i - 1] && !$visited[$i - 1])) {
                continue;
            }
            $visited[$i] = true;
            $path[] = $nums[$i];
            $this->backtrack($cur + 1, $nums, $path, $visited, $res);
            array_pop($path);
            $visited[$i] = false;
        }
    }
}

// test
echo json_encode(new Solution()->permuteUnique([1, 1, 2])) . "\n";
echo json_encode(new Solution()->permuteUnique([1, 2, 3])) . "\n";
