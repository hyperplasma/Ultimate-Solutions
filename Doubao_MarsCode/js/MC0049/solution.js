function solution(n, s, x) {
    const merged = new Map();
    const orderMap = new Map();

    for (let i = 0; i < n; i++) {
        const name = s[i];
        const amount = x[i];

        if (merged.has(name)) {
            merged.set(name, merged.get(name) + amount);
        } else {
            merged.set(name, amount);
            orderMap.set(name, i);
        }
    }

    const entries = Array.from(merged.entries());

    entries.sort((a, b) => {
        const [nameA, amountA] = a;
        const [nameB, amountB] = b;

        if (amountA !== amountB) {
            return amountB - amountA;
        }
        return orderMap.get(nameA) - orderMap.get(nameB);
    });

    return entries.map(([name, _]) => name);
}

function main() {
    console.log(JSON.stringify(solution(4, ["a", "b", "c", "d"], [1, 2, 2, 1])) === JSON.stringify(['b', 'c', 'a', 'd']));
    console.log(JSON.stringify(solution(3, ["x", "y", "z"], [100, 200, 200])) === JSON.stringify(['y', 'z', 'x']));
    console.log(JSON.stringify(solution(5, ["m", "n", "o", "p", "q"], [50, 50, 30, 30, 20])) === JSON.stringify(['m', 'n', 'o', 'p', 'q']));
}

main();