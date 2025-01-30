function solution(n, m, k, a, b) {
    a.sort((x, y) => x - y)
    b.sort((x, y) => x - y)

    let minDiff = Number.MAX_VALUE
    let i = 0, j = 0
    while (i < n && j < m) {
        let diff = Math.abs((a[i] - b[j]) * (a[i] - b[j]) - k * k)
        minDiff = Math.min(minDiff, diff)
        if (a[i] < b[j]) {
            i++
        } else {
            j++
        }
    }

    return minDiff;
}

function main() {
    // You can add more test cases here
    console.log(solution(5, 5, 1, [5, 3, 4, 1, 2], [0, 6, 7, 9, 8]) === 0);
    console.log(solution(5, 5, 0, [5, 3, 4, 1, 2], [0, 6, 7, 9, 8]) === 1);
    console.log(solution(5, 6, 3, [5, 3, 4, 1, 2], [0, 6, 7, 9, 8, 11]) === 0);
}

main();