function solution(n, arr) {
    let maxProd = 0;
    let start = -1, end = -1;

    for (let i = 0; i < n; i++) {
        if (arr[i] === 0) {
            continue;
        }

        let prod = 1
        for (let j = i; j < n; j++) {
            if (arr[j] === 0) {
                break;
            }

            prod *= arr[j];
            if (prod > maxProd) {
                maxProd = prod;
                start = i;
                end = j;
            } else if (prod === maxProd) {
                if (i < start || (i === start && j < end)) {
                    start = i;
                    end = j;
                }
            }
        }
    }

    if (start === -1 || end === -1) {
        return [-1, -1];
    }
    return [start + 1, end + 1];
}

function main() {
    // Add your test cases here
    console.log(solution(5, [1, 2, 4, 0, 8]).toString() === [1, 3].toString());
    console.log(solution(7, [1, 2, 4, 8, 0, 256, 0]).toString() === [6, 6].toString());
}

main();
