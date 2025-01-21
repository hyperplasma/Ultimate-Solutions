function solution(cards) {
    const n = 1010;
    let cnt = new Array(n).fill(0);

    for (let card of cards) {
        cnt[card]++;
    }

    let res = -1;
    for (let card of cards) {
        if (cnt[card] === 1) {
            res = card;
            break;
        }
    }

    return res;
}

function main() {
    // Add your test cases here
    console.log(solution([1, 1, 2, 2, 3, 3, 4, 5, 5]) === 4);
    console.log(solution([0, 1, 0, 1, 2]) === 2);
}

main();
