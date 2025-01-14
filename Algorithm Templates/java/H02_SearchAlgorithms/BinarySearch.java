package H02_SearchAlgorithms;

/**
 * 二分查找
 */
public class BinarySearch {
    static int target;

    /**
     * 查找左边界，即第一个满足条件的元素下标 (lower_bound)
     */
    public static int binarySearchL(int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;    // 计算中间值
            if (ge(mid, target)) {
                r = mid;            // 如果中间的值符合条件，则继续在左边查找
            } else {
                l = mid + 1;        // 否则在右边查找
            }
        }
        return l;    // 返回左边界
    }

    /**
     * 查找右边界，即最后一个满足条件的元素下标 (upper_bound的前驱)
     */
    public static int binarySearchR(int l, int r) {
        while (l < r) {
            int mid = l + r + 1 >> 1;    // 计算中间值，向右偏移
            if (le(mid, target)) {
                l = mid;                // 如果中间的值符合条件（≤），则继续在右边查找
            } else {
                r = mid - 1;            // 否则在左边查找
            }
        }
        return r;    // 返回右边界
    }

    /**
     * 浮点数二分
     */
    public static double binarySearchF(double l, double r) {
        final double eps = 1e-8;        // 精度，视题目而定
        while (r - l > eps) {
            double mid = (l + r) / 2;    // 计算中间值
            if (ge(mid, target)) {
                r = mid;        // 目标在左边，更新右边界
            } else {
                l = mid;        // 否则更新左边界
            }
        }
        return l;    // 返回左边界，即为目标值的估计
    }

    private static boolean ge(int mid, int target) {
        // 自定义比较条件 ...
        return false;
    }

    private static boolean ge(double mid, double target) {
        // 自定义比较条件 ...
        return false;
    }

    private static boolean le(int mid, int target) {
        // 自定义比较条件 ...
        return false;
    }
}
