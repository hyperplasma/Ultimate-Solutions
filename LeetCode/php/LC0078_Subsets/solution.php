<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function subsets(array $nums): array {
        $res = [];
        $this->dfs(0, $nums, [], $res);
        return $res;
    }

    private function dfs($cur, $nums, $path, &$res): void {
        if ($cur == count($nums)) {
            $res[] = $path;
            return;
        }
        $path[] = $nums[$cur];
        $this->dfs($cur + 1, $nums, $path, $res);
        array_pop($path);
        $this->dfs($cur + 1, $nums, $path, $res);
    }
}

// test
echo json_encode(new Solution()->subsets([1, 2, 3])) . "\n";
echo json_encode(new Solution()->subsets([0]));
