package LC1185_DayOfTheWeek;

public class DayOfTheWeek {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dayOfTheWeek(31, 8, 2019));
    }
}

class Solution {
    String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String dayOfTheWeek(int day, int month, int year) {
        int days = 365 * (year - 1971) + (year - 1969) / 4; // 从1971年到year-1年的天数
        for (int i = 0; i < month - 1; ++i) {   // 从1月到month-1月的天数
            days += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {    // 判断是否为闰年
            days += 1;
        }

        days += day; // 加上day天
        return week[(days + 4) % 7]; // 1971年1月1日是星期五，所以+4
    }
}