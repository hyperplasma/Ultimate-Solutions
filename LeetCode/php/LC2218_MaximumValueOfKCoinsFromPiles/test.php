<?php

include "Solution.php";

$piles = [[1, 100, 3], [7, 8, 9]];
$k = 2;
echo new Solution()->maxValueOfCoins($piles, $k);