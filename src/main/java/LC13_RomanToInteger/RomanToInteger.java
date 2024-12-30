package LC13_RomanToInteger;

import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int res = 0;
        char[] chars = s.toCharArray();

        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            switch (ch) {
                case 'M':
                    res += 1000;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'C':
                    if (i + 1 == length) {
                        res += 100;
                    } else {
                        if (chars[i + 1] == 'M') {
                            res += 900;
                            i++;
                        } else if (chars[i + 1] == 'D') {
                            res += 400;
                            i++;
                        } else {
                            res += 100;
                        }
                    }
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'X':
                    if (i + 1 == length) {
                        res += 10;
                    } else {
                        if (chars[i + 1] == 'C') {
                            res += 90;
                            i++;
                        } else if (chars[i + 1] == 'L') {
                            res += 40;
                            i++;
                        } else {
                            res += 10;
                        }
                    }
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'I':
                    if (i + 1 == length) {
                        res += 1;
                    } else {
                        if (chars[i + 1] == 'X') {
                            res += 9;
                            i++;
                        } else if (chars[i + 1] == 'V') {
                            res += 4;
                            i++;
                        } else {
                            res += 1;
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        return res;
    }
}


/**
 * OG, much worse
 */
class Solution2 {
    Map<Character, Integer> symbolValues = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                res -= value;
            } else {
                res += value;
            }
        }
        return res;
    }
}