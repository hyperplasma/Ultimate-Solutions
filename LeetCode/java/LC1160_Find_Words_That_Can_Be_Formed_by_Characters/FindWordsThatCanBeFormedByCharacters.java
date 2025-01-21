package LC1160_Find_Words_That_Can_Be_Formed_by_Characters;

/**
 * <a href="https://leetcode.cn/problems/find-words-that-can-be-formed-by-characters/">Find Words That Can Be Formed by Characters</a>
 * 数组；哈希表；字符串；计数
 */
public class FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }
}

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCounter = getCharCounter(chars);

        int res = 0;
        for (String word : words) {
            int[] wordCount = getCharCounter(word);

            boolean canSpell = true;
            for (int i = 0; i < 26; i++) {
                if (charCounter[i] < wordCount[i]) {
                    canSpell = false;
                    break;
                }
            }
            if (canSpell) {
                res += word.length();
            }
        }
        return res;
    }

    private int[] getCharCounter(String chars) {
        int[] charCounter = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            char ch = chars.charAt(i);
            charCounter[ch - 'a']++;
        }
        return charCounter;
    }
}