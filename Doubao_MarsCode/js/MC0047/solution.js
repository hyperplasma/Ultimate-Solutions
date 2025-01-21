function solution(n, l, r, a) {
    let cnt = 0;
    for (let num of a) {
        if (num % 2 === 0 && num >= l && num <= r) {
            cnt++;
        }
    }
    return cnt;
}

function main() {
    console.log(solution(5, 3, 8, [1, 2, 6, 8, 7]) === 2);
    console.log(solution(4, 10, 20, [12, 15, 18, 9]) === 2);
    console.log(solution(3, 1, 10, [2, 4, 6]) === 3);
}

main();