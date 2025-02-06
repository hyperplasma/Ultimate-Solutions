<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function permute(array $nums): array {
        $res = [];
        $output = $nums;
        $this->backtrack(0, count($nums), $output, $res);
        return $res;
    }

    private function backtrack(int $cur, int $n, array &$output, array &$res): void {
        if ($cur == $n) {
            $res[] = $output;
            return;
        }

        for ($i = $cur; $i < $n; $i++) {
            [$output[$cur], $output[$i]] = [$output[$i], $output[$cur]];
            $this->backtrack($cur + 1, $n, $output, $res);
            [$output[$cur], $output[$i]] = [$output[$i], $output[$cur]];
        }
    }
}

// test
echo json_encode(new Solution()->permute([1, 2, 3]), JSON_PRETTY_PRINT);
echo json_encode(new Solution()->permute([0, 1]), JSON_PRETTY_PRINT);