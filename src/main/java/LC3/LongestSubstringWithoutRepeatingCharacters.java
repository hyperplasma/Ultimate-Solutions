package LC3;

import java.util.*;


class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        boolean[] map = new boolean[128];
        Arrays.fill(map, false);
        map[s.charAt(0)] = true;

        int i = 0;
        int maxLength = 1;
        for (int j = 1; j < s.length(); j++) {

            if (!map[s.charAt(j)]) {
                maxLength = Math.max(maxLength, j - i + 1);
            } else {
                while (map[s.charAt(j)]) {
                    map[s.charAt(i++)] = false;
                }
            }

            map[s.charAt(j)] = true;
        }

        return maxLength;
    }
}

/**
 * OG, much worse
 */
class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        if (!s.isEmpty()) {
            sb.append(s.charAt(0));
        }

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = sb.indexOf(String.valueOf(s.charAt(i)));

            if (index != -1) {
                sb.delete(0, index + 1);
            }
            sb.append(s.charAt(i));

            maxLength = Math.max(maxLength, sb.length());
        }

        return maxLength;
    }
}