package LC0732_MyCalenderIII;

import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/my-calendar-iii/">My Calender III</a>
 * 设计；线段树；二分查找；有序集合；前缀和
 */
public class MyCalenderIII {
    public static void main(String[] args) {
        MyCalendarThree cal = new MyCalendarThree();
        System.out.println(cal.book(10, 20)); // returns 0
    }
}

/**
 * 差分数组
 */
class MyCalendarThree {
    private final TreeMap<Integer, Integer> cnt;

    public MyCalendarThree() {
        cnt = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        int res = 0;
        int maxBook = 0;
        cnt.put(startTime, cnt.getOrDefault(startTime, 0) + 1); // 从startTime开始的预定数目加1
        cnt.put(endTime, cnt.getOrDefault(endTime, 0) - 1); // 从endTime开始的预定数目减1
        for (var entry : cnt.entrySet()) {
            int freq = entry.getValue();    // 以起点x开始的预定的总数目为 \Sum_{i \le x} cnt[i]
            maxBook += freq;
            res = Math.max(maxBook, res);
        }
        return res;
    }
}
