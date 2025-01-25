var minimumMoney = function (transactions) {
    let totalLose = 0;
    let res = 0;
    for (let t of transactions) {
        const cost = t[0];
        const cashback = t[1];
        totalLose += Math.max(cost - cashback, 0);
        res = Math.max(res, Math.min(cost, cashback));
    }
    return totalLose + res;
};

function test() {
    console.log(minimumMoney([[2, 1], [3, 2], [10, 3]]));
}

test();