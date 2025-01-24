var minimumCoins = function (prices) {
    const n = prices.length;
    const queue = [];
    queue.push([n, 0]);
    for (let i = n - 1; i >= 0; i--) {
        while (queue[queue.length - 1][0] >= 2 * i + 3) {
            queue.pop();
        }
        let cur = queue[queue.length - 1][1] + prices[i];
        while (queue[0][1] >= cur) {
            queue.shift();
        }
        queue.unshift([i, cur]);
    }
    return queue[0][1];
};

function test() {
    console.log(minimumCoins([26, 18, 6, 12, 49, 7, 45, 45]));
}

test();