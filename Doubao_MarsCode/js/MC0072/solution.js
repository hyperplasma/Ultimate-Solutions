function solution(num, data) {
    let rCnt = new Array(num).fill(0);  // > 0
    let lCnt = new Array(num).fill(0);  // < 0

    for (let i = 1; i < num; i++) {
        if ((data[i - 1] === 'R' && data[i] === '.') || (rCnt[i - 1] > 0 && data[i] === '.')) {
            rCnt[i] = rCnt[i - 1] + 1;
        }
    }
    for (let i = num - 2; i >= 0; i--) {
        if ((data[i + 1] === 'L' && data[i] === '.') || (lCnt[i + 1] < 0 && data[i] === '.')) {
            lCnt[i] = lCnt[i + 1] - 1;
        }
    }

    let res = "";
    let sum = 0;
    for (let i = 0; i < num; i++) {
        if (data[i] === '.' && rCnt[i] + lCnt[i] === 0) {
            if (res !== "") {
                res += ",";
            }
            res += (i + 1);
            sum++;
        }
    }

    if (sum === 0) {
        return "0";
    }
    return sum + ":" + res;
}

function main() {
    //  You can add more test cases here
    console.log(solution(14, ".L.R...LR..L..") === "4:3,6,13,14");
    console.log(solution(5, "R....") === "0");
    console.log(solution(1, ".") === "1:1");
}

main();