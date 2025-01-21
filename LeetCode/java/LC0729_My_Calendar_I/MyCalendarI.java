package LC0729_My_Calendar_I;

import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/my-calendar-i/">My Calendar I</a>
 * 设计；线段树；数组；二分查找；有序集合
 */
public class MyCalendarI {
    public static void main(String[] args) {
        MyCalendar obj = new MyCalendar();
        System.out.println("obj.book(10, 20) = " + obj.book(10, 20));
        System.out.println("obj.book(15, 25) = " + obj.book(15, 25));
        System.out.println("obj.book(20, 30) = " + obj.book(20, 30));
    }
}

class MyCalendar {
    private final TreeMap<Integer, Integer> booked;   // <endTime, startTime> 根据结束时间排序

    public MyCalendar() {
        this.booked = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        var e = booked.higherEntry(startTime);
        if (e != null && e.getValue() < endTime) {
            return false;
        }
        booked.put(endTime, startTime);
        return true;
    }
}

//class MyCalendar {
//    List<int[]> booked;
//
//    public MyCalendar() {
//        this.booked = new ArrayList<>();
//    }
//
//    public boolean book(int startTime, int endTime) {
//        for (int[] interval : booked) {
//            int l = interval[0], r = interval[1];
//            if (l < endTime && startTime < r) {
//                return false;
//            }
//        }
//        booked.add(new int[]{startTime, endTime});
//        return true;
//    }
//}