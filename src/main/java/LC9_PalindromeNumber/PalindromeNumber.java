package LC9_PalindromeNumber;


class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x % 10 == 0 && x != 0) {
            return false;
        }

        int temp = 0;
        while (x > temp) {
            temp = temp * 10 + x % 10;
            if (x == temp) break;
            x /= 10;
            if (x == temp) break;
        }
        return x == temp;
    }
}

/**
 * OG, much worse
 */
class Solution2 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        if (s.charAt(0) == '-') {
            return false;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
    }
}