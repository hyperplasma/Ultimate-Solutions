<?php

class Solution {
    /**
     * @param Integer[][] $edges
     * @param Integer[] $coins
     * @param Integer $k
     * @return Integer
     */
    function maximumPoints(array $edges, array $coins, int $k): int {
        $n = count($coins);
        $children = array_fill(0, $n, []);
        foreach ($edges as $edge) {
            $children[$edge[0]][] = $edge[1];
            $children[$edge[1]][] = $edge[0];
        }
        $memo = array_fill(0, $n, array_fill(0, 14, -1));
        return $this->dfs(0, -1, 0, $coins, $k, $children, $memo);
    }

    function dfs($node, $parent, $f, $coins, $k, $children, &$memo) {
        if ($memo[$node][$f] != -1) {
            return $memo[$node][$f];
        }
        $res0 = ($coins[$node] >> $f) - $k;
        $res1 = $coins[$node] >> ($f + 1);
        foreach ($children[$node] as $child) {
            if ($child == $parent) {
                continue;
            }
            $res0 += $this->dfs($child, $node, $f, $coins, $k, $children, $memo);
            if ($f + 1 < 14) {
                $res1 += $this->dfs($child, $node, $f + 1, $coins, $k, $children, $memo);
            }
        }
        $memo[$node][$f] = max($res0, $res1);
        return $memo[$node][$f];
    }
}

// test
echo new Solution()->maximumPoints([[0, 1], [1, 2], [2, 3]], [10, 10, 3, 3], 5);