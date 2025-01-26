<?php

class Solution {

    /**
     * @param Integer[] $candidates
     * @param Integer $target
     * @return Integer[][]
     */
    function combinationSum2(array $candidates, int $target): array {
        $res = [];
        sort($candidates);
        $this->backtrack($candidates, $target, 0, [], $res);
        return $res;
    }

    function backtrack($candidates, $target, $start, $path, &$res): void {
        if ($target === 0) {
            $res[] = $path;
            return;
        }
        for ($i = $start; $i < count($candidates); $i++) {
            if ($i > $start && $candidates[$i] === $candidates[$i - 1]) {
                continue;
            }
            if ($target - $candidates[$i] < 0) {
                break;
            }
            $path[] = $candidates[$i];
            $this->backtrack($candidates, $target - $candidates[$i], $i + 1, $path, $res);
            array_pop($path);
        }
    }
}

// test
echo json_encode(new Solution()->combinationSum2([10, 1, 2, 7, 6, 1, 5], 8));