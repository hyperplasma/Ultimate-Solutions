function solution(n, b, sequence) {
    let res = 0;
    let prefixSum = 0;
    let count = new Map();

    for (let num of sequence) {
        prefixSum += num;
        let mod = prefixSum % b;

        if (mod === 0) {
            res++;
        }

        if (count.has(mod)) {
            res += count.get(mod);
        }

        count.set(mod, (count.get(mod) || 0) + 1);
    }

    return res;
}

function main() {
    // You can add more test cases here
    console.log(solution(3, 3, [1, 2, 3]) === 3);
    console.log(solution(5, 2, [1, 2, 3, 4, 5]) === 6);
}

main();