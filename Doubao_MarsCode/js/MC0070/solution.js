function solution(inputArray) {
    inputArray.sort((a, b) => a[0] - b[0]);

    let start = 0, end = 0, cnt = 0;
    for (let seg of inputArray) {
        if (seg[0] > end) {
            cnt += end - start + 1;
            start = seg[0];
            end = seg[1];
        } else if (seg[1] > end) {
            end = seg[1];
        }
    }
    cnt += end - start;
    return cnt;
}

function main() {
    //  You can add more test cases here
    const testArray1 = [[1, 4], [7, 10], [3, 5]];
    const testArray2 = [[1, 2], [6, 10], [11, 15]];

    console.log(solution(testArray1) === 9);
    console.log(solution(testArray2) === 12);
}

main();