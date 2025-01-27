function solution(plates, n) {
    let res = "";
    for (let i = 0; i < n; i++) {
        let j = i;
        while (i + 1 < n && plates[i + 1] - plates[i] === 1) {
            i++;
        }
        if (i - j + 1 >= 3) {
            res += `${plates[j]}-${plates[i]},`;
        } else if (i - j + 1 === 2) {
            res += `${plates[j]},${plates[j + 1]},`;
        } else {
            res += `${plates[j]},`;
        }
    }
    return res.slice(0, -1);
}

function main() {
    //  You can add more test cases here
    console.log(solution([-3, -2, -1, 2, 10, 15, 16, 18, 19, 20], 10) === "-3--1,2,10,15,16,18-20");
    console.log(solution([-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20], 20) === "-6,-3-1,3-5,7-11,14,15,17-20");
    console.log(solution([1, 2, 7, 8, 9, 10, 11, 19], 8) === "1,2,7-11,19");
}

main();