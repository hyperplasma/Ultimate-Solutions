<?php

class Solution {

    /**
     * @param String $s
     * @return Boolean
     */
    function validPalindrome(string $s): bool {
        $low = 0;
        $high = strlen($s) - 1;
        while ($low < $high) {
            if ($s[$low] == $s[$high]) {
                $low++;
                $high--;
            } else {
                return $this->checkPalindrome($s, $low, $high - 1) || $this->checkPalindrome($s, $low + 1, $high);
            }
        }
        return true;
    }

    private function checkPalindrome(string $s, int $low, int $high): bool {
        for ($i = $low, $j = $high; $i < $j; $i++, $j--) {
            if ($s[$i] != $s[$j]) {
                return false;
            }
        }
        return true;
    }
}

// test
echo new Solution()->validPalindrome("aba");
echo new Solution()->validPalindrome("abca");
echo new Solution()->validPalindrome("abc");