package MC0096;

/**
 * 96. 时尚圈的衣着稳定性问题
 */
public class Main {
    public static int[] solution(int n, String data) {
        int[] result = new int[]{-1, -1};
        StringBuffer tmp = new StringBuffer(data);
        int changes = 0;
        int days = 0;
        changes = getChanges(n, tmp, changes);

        // System.out.println(changes);
        if (changes == n) {
            return result;
        }

        days++;
        while (changes != 0) {
            changes = 0;
            StringBuffer k = new StringBuffer(tmp.toString());
            System.out.println(tmp);
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    if (tmp.charAt(0) == tmp.charAt(n - 1) && tmp.charAt(0) == tmp.charAt(1)) {
                        if (tmp.charAt(0) == '0') {
                            k.setCharAt(0, '1');
                        } else {
                            k.setCharAt(0, '0');
                        }
                        // changes++;
                    }
                } else if (i == n - 1) {
                    if (tmp.charAt(n - 1) == tmp.charAt(n - 2) && tmp.charAt(n - 1) == tmp.charAt(0)) {
                        if (tmp.charAt(n - 1) == '0') {
                            k.setCharAt(n - 1, '1');
                        } else {
                            k.setCharAt(n - 1, '0');
                        }
                        // changes++;
                    }
                } else {
                    if (tmp.charAt(i) == tmp.charAt(i + 1) && tmp.charAt(i) == tmp.charAt(i - 1)) {
                        if (tmp.charAt(i) == '0') {
                            k.setCharAt(i, '1');
                        } else {
                            k.setCharAt(i, '0');
                        }
                        // changes++;
                    }
                }
            }
            System.out.println(tmp);
            tmp = k;
            days++;
            changes = getChanges(n, tmp, changes);
        }
        // System.out.println(tmp.toString());

        result[1] = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (tmp.charAt(0) != tmp.charAt(n - 1) && tmp.charAt(0) != tmp.charAt(1)) {
                    // System.out.println(result[1]);
                    result[1]++;
                }
            } else if (i == n - 1) {
                if (tmp.charAt(n - 1) != tmp.charAt(n - 2) && tmp.charAt(n - 1) != tmp.charAt(0)) {
                    // System.out.println(result[1]);
                    result[1]++;
                }
            } else {
                if (tmp.charAt(i) != tmp.charAt(i + 1) && tmp.charAt(i) != tmp.charAt(i - 1)) {
                    // System.out.println(result[1]);
                    result[1]++;
                }
            }
        }
        result[0] = days;
        return result;
    }

    private static int getChanges(int n, StringBuffer tmp, int changes) {
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (tmp.charAt(0) == tmp.charAt(n - 1) && tmp.charAt(0) == tmp.charAt(1)) {
                    changes++;
                }
            } else if (i == n - 1) {
                if (tmp.charAt(n - 1) == tmp.charAt(n - 2) && tmp.charAt(n - 1) == tmp.charAt(0)) {
                    changes++;
                }
            } else {
                if (tmp.charAt(i) == tmp.charAt(i + 1) && tmp.charAt(i) == tmp.charAt(i - 1)) {
                    changes++;
                }
            }
        }
        return changes;
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(java.util.Arrays.equals(solution(4, "0000"), new int[]{-1, -1}));
        System.out.println(java.util.Arrays.equals(solution(4, "1110"), new int[]{2, 4}));
    }
}
