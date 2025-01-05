package LC2241_DesignAnATMMachine;

/**
 * <a href="https://leetcode.cn/problems/design-an-atm-machine/">Design an ATM Machine</a>
 * 贪心；设计；数组
 */
public class DesignAnATMMachine {
}

class ATM {
    private int[] cnt;
    private int[] values;

    public ATM() {
        cnt = new int[5];
        values = new int[]{20, 50, 100, 200, 500};
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            cnt[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] res = new int[5];
        for (int i = 4; i >= 0; i--) {
            if (amount >= values[i] && cnt[i] > 0) {
                res[i] = Math.min(cnt[i], amount / values[i]);
                amount -= res[i] * values[i];
            } else {
                res[i] = 0;
            }
        }
        if (amount > 0) {
            return new int[]{-1};
        } else {
            for (int i = 0; i < 5; i++) {
                cnt[i] -= res[i];
            }
            return res;
        }
    }
}
