function solution(V, W) {
    if (V <= 5) {
        return "YES";
    }

    while (W > 0) {
        let remainder = W % V;
        if (remainder <= 2) {
            W /= V;
        } else if (remainder >= V - 2) {
            W = Math.floor(W / V) + 1;
        } else {
            return "NO";
        }
    }

    return "YES";
}

function main() {
    // Add your test cases here
    console.log(solution(10, 9) === "YES");
    console.log(solution(200, 40199) === "YES");
    console.log(solution(108, 50) === "NO");
}

main();
