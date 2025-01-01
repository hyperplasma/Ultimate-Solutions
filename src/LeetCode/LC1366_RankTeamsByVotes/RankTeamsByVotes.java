package LeetCode.LC1366_RankTeamsByVotes;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/rank-teams-by-votes/">Rank Teams By Votes</a>
 * 数组；哈希表；字符串；计数；排序
 */
public class RankTeamsByVotes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
    }
}

class Solution {
    public String rankTeams(String[] votes) {
        int[][] rank = new int[26][27];

        for (int i = 0; i < 26; i++) {
            rank[i][0] = i;
        }

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                rank[vote.charAt(i) - 'A'][i + 1]++;
            }
        }

        Arrays.sort(rank, (o1, o2) -> {
            for (int i = 1; i < 27; i++) {
                if (o1[i] != o2[i]) {
                    return o2[i] - o1[i];
                }
            }
            return 1;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < votes[0].length(); i++) {
            sb.append((char) (rank[i][0] + 'A'));
        }

        return sb.toString();
    }
}