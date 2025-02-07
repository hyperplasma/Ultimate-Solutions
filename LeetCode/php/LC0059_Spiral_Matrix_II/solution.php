<?php

class Solution {

    /**
     * @param Integer $n
     * @return Integer[][]
     */
    function generateMatrix(int $n) {
        $res = array_fill(0, $n, array_fill(0, $n, 0));
        $cur = 1;

        $i = $j = 0;
        while ($cur <= $n * $n) {
            while ($j < $n && $res[$i][$j] == 0) {
                $res[$i][$j++] = $cur++;
            }
            $j--;
            $i++;
            while ($i < $n && $res[$i][$j] == 0) {
                $res[$i++][$j] = $cur++;
            }
            $i--;
            $j--;
            while ($j >= 0 && $res[$i][$j] == 0) {
                $res[$i][$j--] = $cur++;
            }
            $j++;
            $i--;
            while ($i >= 0 && $res[$i][$j] == 0) {
                $res[$i--][$j] = $cur++;
            }
            $i++;
            $j++;
        }
        return $res;
    }
}

// test
echo json_encode(new Solution()->generateMatrix(3)) . "\n";
echo json_encode(new Solution()->generateMatrix(1)) . "\n";