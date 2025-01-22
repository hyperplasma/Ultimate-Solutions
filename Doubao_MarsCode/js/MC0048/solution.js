function solution(s) {
    return s.replaceAll("a", "%100");
}

function main() {
    console.log(solution("abcdwa") === "%100bcdw%100");
    console.log(solution("banana") === "b%100n%100n%100");
    console.log(solution("apple") === "%100pple");
}

main();