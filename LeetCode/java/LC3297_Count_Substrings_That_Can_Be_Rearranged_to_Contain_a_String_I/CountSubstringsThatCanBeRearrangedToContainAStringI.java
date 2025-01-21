package LC3297_Count_Substrings_That_Can_Be_Rearranged_to_Contain_a_String_I;

/**
 * <a href="https://leetcode.cn/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i/">Count Substrings That Can Be Rearranged to Contain a String I</a>
 * 哈希表；字符串；滑动窗口
 */
public class CountSubstringsThatCanBeRearrangedToContainAStringI {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validSubstringCount("abcabc", "abc"));
    }
}

class Solution {
    public long validSubstringCount(String word1, String word2) {
        int[] cnt = new int[26];
        int diff = 0;    // word2中剩余的字符种类数
        for (char c : word2.toCharArray()) {
            int index = c - 'a';
            if (cnt[index] == 0) {
                diff++;
            }
            cnt[index]++;
        }

        long res = 0;
        char[] arr = word1.toCharArray();
        for (int left = 0, right = 0; right < arr.length; right++) {
            int push = arr[right] - 'a';
            cnt[push]--;
            if (cnt[push] == 0) {
                diff--;
            }
            while (diff == 0) {
                int pop = arr[left++] - 'a';
                if (cnt[pop] == 0) {
                    diff++;
                }
                cnt[pop]++;
            }
            // 每当diff为0时，说明当前窗口内的子串可以重新排列成word2
            // 此时窗口左边界left之前的所有字符都可以作为窗口的起始位置，因此可以形成left个满足条件的子串
            res += left;    // 将left加到res中，累加满足条件的子串数量
        }

        return res;
    }
}