<?php

class Solution {

    /**
     * @param String $s
     * @param Integer $k
     * @return String
     */
    function reverseStr(string $s, int $k) {
        $arr = str_split($s);
        for ($i = 0; $i < strlen($s); $i += 2 * $k) {
            $this->reverse($arr, $i, min($i + $k, strlen($s)) - 1);
        }
        return implode('', $arr);
    }

    function reverse(&$arr, $l, $r) {
        while ($l < $r) {
            $temp = $arr[$l];
            $arr[$l] = $arr[$r];
            $arr[$r] = $temp;
            $l++;
            $r--;
        }
    }
}

// test
echo new Solution()->reverseStr("abcdefg", 2);