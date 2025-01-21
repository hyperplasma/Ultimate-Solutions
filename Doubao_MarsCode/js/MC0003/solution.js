function solution(s) {
    // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE

    // 去除前导零
    s = s.replace(/^0+(?!$)/, '');

    // 分离整数和小数部分
    let parts = s.split('.');
    let integerPart = parts[0];
    let decimalPart = parts.length > 1 ? '.' + parts[1] : '';

    // 格式化整数部分
    let formattedInteger = '';
    let count = 0;
    for (let i = integerPart.length - 1; i >= 0; i--) {
        formattedInteger = integerPart[i] + formattedInteger;
        count++;
        if (count % 3 === 0 && i !== 0) {
            formattedInteger = ',' + formattedInteger;
        }
    }

    // 合并整数和小数部分
    return formattedInteger + decimalPart;
}


function main() {
    console.log(solution("1294512.12412") === '1,294,512.12412');
    console.log(solution("0000123456789.99") === '123,456,789.99');
    console.log(solution("987654321") === '987,654,321');
}

main();