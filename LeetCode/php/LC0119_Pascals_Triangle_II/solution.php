<?php

class Solution {

    /**
     * @param Integer $rowIndex
     * @return Integer[]
     */
    function getRow(int $rowIndex): array {
        $row = [1];
        for ($i = 1; $i <= $rowIndex; ++$i) {
            $row[] = (int)(($row[$i - 1] * ($rowIndex - $i + 1)) / $i);
        }
        return $row;
    }
}

// test
echo json_encode(new Solution()->getRow(3));