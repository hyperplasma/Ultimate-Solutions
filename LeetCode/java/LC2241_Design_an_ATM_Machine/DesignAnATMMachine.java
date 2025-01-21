package LC2241_Design_an_ATM_Machine;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/design-an-atm-machine/">Design an ATM Machine</a>
 * 贪心；设计；数组
 */
public class DesignAnATMMachine {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{0, 0, 1, 2, 1});
        System.out.println(Arrays.toString(atm.withdraw(600))); // [0,0,1,0,1]
    }
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
