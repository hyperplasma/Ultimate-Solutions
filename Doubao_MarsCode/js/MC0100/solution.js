function solution(A) {
    let n = A.length;
    let sorted = [...A];
    sorted.sort((a, b) => a - b);

    let cnt = 0;
    for (let score of A) {
        let numLessOrEqual = countLessOrEqual(sorted, score);
        let numGreater = n - numLessOrEqual;
        if (numLessOrEqual > numGreater) {
            cnt++;
        }
    }
    return cnt;
}

function countLessOrEqual(sorted, target) {
    let low = 0, high = sorted.length - 1;
    while (low <= high) {
        let mid = Math.floor((low + high) / 2);
        if (sorted[mid] <= target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return low; // low指向第一个大于target的位置，因此小于等于target的数量是low
}

function main() {
    // Add your test cases here
    console.log(solution([100, 100, 100]) === 3);
    console.log(solution([2, 1, 3]) === 2);
    console.log(solution([30, 1, 30, 30]) === 3);
    console.log(solution([19, 27, 73, 55, 88]) === 3);
    console.log(solution([19, 27, 73, 55, 88, 88, 2, 17, 22]) === 5);
}

main();
