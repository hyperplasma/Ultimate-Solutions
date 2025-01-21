<?php

include "Solution.php";

$nums = [2, 7, 11, 15];
$target = 9;
$result = new Solution()->twoSum($nums, $target);
echo implode(",", $result);