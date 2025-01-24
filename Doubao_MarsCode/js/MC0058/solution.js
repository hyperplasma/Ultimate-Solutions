function solution(rawStr, encodedStr) {
    const base32Chars = "9876543210mnbvcxzasdfghjklpoiuyt";
    const base32Map = new Map();

    // 初始化映射表
    for (let i = 0; i < base32Chars.length; i++) {
        base32Map.set(base32Chars[i], i);
    }

    // Base32 编码
    function encodeBase32(str) {
        let binaryStr = "";
        for (let i = 0; i < str.length; i++) {
            binaryStr += str[i].charCodeAt(0).toString(2).padStart(8, "0");
        }
        // 补齐到5的倍数
        while (binaryStr.length % 5 !== 0) {
            binaryStr += "0";
        }
        let encoded = "";
        for (let i = 0; i < binaryStr.length; i += 5) {
            let group = binaryStr.substring(i, i + 5);
            let index = parseInt(group, 2);
            encoded += base32Chars[index];
        }
        // 添加填充字符
        let paddingCount = (8 - (encoded.length % 8)) % 8;
        encoded += "+".repeat(paddingCount);
        return encoded;
    }

    // Base32 解码
    function decodeBase32(encoded) {
        let decoded = "";
        let parts = encoded.split("+").filter(Boolean);
        for (let part of parts) {
            let binaryStr = "";
            for (let char of part) {
                let index = base32Map.get(char);
                binaryStr += index.toString(2).padStart(5, "0");
            }
            for (let i = 0; i < binaryStr.length; i += 8) {
                if (i + 8 > binaryStr.length) break;
                let byteStr = binaryStr.substring(i, i + 8);
                let ascii = parseInt(byteStr, 2);
                decoded += String.fromCharCode(ascii);
            }
        }
        return decoded;
    }

    let encoded = encodeBase32(rawStr);
    let decoded = decodeBase32(encodedStr);
    return encoded + ":" + decoded;
}

function main() {
    console.log(solution("foo", "b0zj5+++") === "bljhy+++:bar");
    console.log(solution("The encoding process", "bljhy+++b0zj5+++") === "maf3m164vlahyl60vlds9i6svuahmiod:foobar");
    console.log(solution("Base32 encoding and decoding", "bvchz+++v4j21+++cals9+++") === "10zj3l0d31z3mod6vus3sod258zhil89bash3oo5v4j3c+++:c]hintts ");
}

main();