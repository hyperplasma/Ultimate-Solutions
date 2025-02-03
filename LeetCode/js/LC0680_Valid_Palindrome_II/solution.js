/**
 * @param {string} s
 * @return {boolean}
 */
var validPalindrome = function (s) {
    let low = 0, high = s.length - 1;
    while (low < high) {
        if (s[low] === s[high]) {
            low++;
            high--;
        } else {
            return checkPalindrome(s, low, high - 1) || checkPalindrome(s, low + 1, high);
        }
    }
    return true;
};

function checkPalindrome(s, low, high) {
    for (let i = low, j = high; i < j; i++, j--) {
        if (s[i] !== s[j]) {
            return false;
        }
    }
    return true;
}

function test() {
    console.log(validPalindrome("aba"));
    console.log(validPalindrome("abca"));
    console.log(validPalindrome("abc"));
}

test();