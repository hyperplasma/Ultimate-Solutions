function solution(n, k, b, c) {
    const dp = Array.from({ length: n + 1 }, () => Array(k + 1).fill(0));
    const step = Array(n + 1).fill(0); // 记录每个英雄达到目标所需要的升级次数

    // 计算每个英雄的升级次数
    for (let i = 1; i <= n; i++) {
        let a = 1;
        let x = 1;
        while (a !== b[i - 1]) {
            if (a + Math.floor(a / x) <= b[i - 1]) {
                step[i]++;
                a += Math.floor(a / x);
            } else if (a + Math.floor(a / x) > b[i - 1]) {
                x++;
            }
        }
    }

    // 初始化DP数组
    for (let i = 0; i <= k; i++) {
        dp[0][i] = 0;
    }
    for (let i = 1; i <= n; i++) {
        if (step[i] === 0) {
            dp[i][0] = c[i - 1] + dp[i - 1][0];
        } else {
            dp[i][0] = dp[i - 1][0];
        }
    }

    // 动态规划计算最大奖励
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= k; j++) {
            if (j < step[i]) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - step[i]] + c[i - 1]);
            }
        }
    }

    return dp[n][k];
}

function main() {
    // Add your test cases here
    console.log(solution(4, 4, [1, 7, 5, 2], [2, 6, 5, 2]) === 9);
    console.log(solution(3, 0, [3, 5, 2], [5, 4, 7]) === 0);
}

main();