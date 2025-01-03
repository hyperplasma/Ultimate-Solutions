package MC0009;

/**
 * 9. 超市里的货物架调整
 * 贪心；模拟
 */
public class Main {
    public static int solution(int n, int m, String s, String c) {
        // 统计货架上每种商品的数量
        int[] shelfCount = new int[26];
        for (char ch : s.toCharArray()) {
            shelfCount[ch - 'a']++;
        }

        // 统计顾客想要的每种商品的数量
        int[] customerCount = new int[26];
        for (char ch : c.toCharArray()) {
            customerCount[ch - 'a']++;
        }

        // 计算每种商品在货架上和顾客需求中的最小值
        int maxSales = 0;
        for (int i = 0; i < 26; i++) {
            if (customerCount[i] > 0) {
                maxSales += Math.min(shelfCount[i], customerCount[i]);
            }
        }

        return maxSales;
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(3, 4, "abc", "abcd") == 3);
        System.out.println(solution(4, 2, "abbc", "bb") == 2);
        System.out.println(solution(5, 4, "bcdea", "abcd") == 4);
    }
}