<?php

class Solution {

    /**
     * @param Integer[] $nums1
     * @param Integer[] $nums2
     * @return Integer[]
     */
    function intersect(array $nums1, array $nums2): array {
        if (count($nums1) > count($nums2)) {
            return $this->intersect($nums2, $nums1);
        }

        $map = [];
        foreach ($nums1 as $num) {
            $map[$num] = ($map[$num] ?? 0) + 1;
        }

        $res = [];
        foreach ($nums2 as $num) {
            $cnt = $map[$num] ?? 0;
            if ($cnt > 0) {
                $res[] = $num;
                $cnt--;
                if ($cnt > 0) {
                    $map[$num] = $cnt;
                } else {
                    unset($map[$num]);
                }
            }
        }
        return $res;
    }
}

// test
echo json_encode(new Solution()->intersect([1, 2, 2, 1], [2, 2]), JSON_PRETTY_PRINT);