<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function subsetsWithDup(array $nums): array {
        sort($nums);
        $res = [];
        $this->dfs(false, 0, $nums, [], $res);
        return $res;
    }

    private function dfs($choose_pre, $cur, $nums, $path, &$res): void {
        if ($cur == count($nums)) {
            $res[] = $path;
            return;
        }
        $this->dfs(false, $cur + 1, $nums, $path, $res);
        if (!$choose_pre && $cur > 0 && $nums[$cur] == $nums[$cur - 1]) {
            return;
        }
        $path[] = $nums[$cur];
        $this->dfs(true, $cur + 1, $nums, $path, $res);
        array_pop($path);
    }
}

// test
echo json_encode(new Solution()->subsetsWithDup([1, 2, 2]));
echo json_encode(new Solution()->subsetsWithDup([0]));