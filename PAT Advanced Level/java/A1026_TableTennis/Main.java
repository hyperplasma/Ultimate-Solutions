package A1026_TableTennis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 测试点8超时
 */
public class Main {
    static List<Node> user;
    static List<Table> table;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        user = new ArrayList<>();
        table = new ArrayList<>();

        // 读入运动员信息
        for (int i = 0; i < n; i++) {
            String[] times = sc.next().split(":");
            Node node = new Node(calTime(times), sc.nextInt() * 60, sc.nextInt());
            user.add(node);
        }

        // 读取桌子信息
        int k = sc.nextInt(), m = sc.nextInt();// 桌子数和vip桌子数
        for (int i = 0; i < k; i++) {
            Table t = new Table(0, 8 * 3600, 0);
            table.add(t);
        }

        // 设置vip桌子
        for (int i = 0; i < m; i++) {
            int c = sc.nextInt() - 1;// 桌子的序号为N-1
            table.get(c).tag = 1;
        }

        // 按到时间升序排序
        user.sort(Comparator.comparingInt(n2 -> n2.arrive));

        // 开始处理服务
        for (int i = 0; i < n; i++) {
            if (user.get(i).serve != Integer.MAX_VALUE)
                continue;
            // 找出最早空闲的时间，采用从头到尾遍历的方式。
            int minFreeTime = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                minFreeTime = Math.min(minFreeTime, table.get(j).freeTime);
            }
            // 确定最早开始服务的时间
            int timePoint = Math.max(user.get(i).arrive, minFreeTime);
            if (timePoint >= 21 * 3600)
                break;
            List<Integer> userList = new ArrayList<>();
            List<Integer> tableList = new ArrayList<>();
            // 根据time Point找到所有可能被服务的人，是为了处理有VIP优先去VIP桌的情况
            for (int j = i; j < n; j++)
                if (user.get(j).serve == Integer.MAX_VALUE && user.get(j).arrive <= timePoint)
                    userList.add(j);
            // 找出timePoint之前空闲的桌子，因为可能用户到达比较晚，会有多个桌子空闲
            for (int j = 0; j < k; j++)
                if (table.get(j).freeTime <= timePoint)
                    tableList.add(j);

            boolean flag = false;   // 判断是否处理了一个服务
            // 首先特殊处理VIP，如果没有VIP被处理则处理一个普通用户，每次只处理一个
            if (userList.size() == 1 && tableList.size() > 1) {
                if (user.get(userList.get(0)).tag == 1) {
                    for (Integer integer : tableList) {
                        if (table.get(integer).tag == 1) {
                            flag = true;
                            updateInfo(userList.get(0), integer);
                            break;
                        }
                    }
                }
            } else if (tableList.size() == 1 && userList.size() > 1) {  // 一桌多人，要考虑VIP用户
                if (table.get(tableList.get(0)).tag == 1) {
                    for (Integer integer : userList) {
                        if (user.get(integer).tag == 1) {
                            flag = true;
                            updateInfo(integer, tableList.get(0));
                            break;
                        }
                    }
                }
            } else if (tableList.size() > 1 && userList.size() > 1) {   // 多人多桌
                for (Integer integer : tableList) {
                    if (table.get(integer).tag == 1) {
                        for (Integer value : userList) {
                            if (user.get(value).tag == 1) {
                                flag = true;
                                updateInfo(value, integer);
                                break;
                            }
                        }
                    }
                }
            }
            if (!flag)// 如果还没有被处理，则第一个与第一个配对
                updateInfo(userList.get(0), tableList.get(0));
            i--;// 如果处理的是第i个人，写一次循环会直接continue
        }

        // 根据服务时间和到达时间排序
        user.sort((o1, o2) -> {
            if (o1.serve == o2.serve)
                return o2.arrive - o1.arrive;
            return o1.serve - o2.serve;
        });
        for (int i = 0; i < n; i++) {
            if (user.get(i).serve >= 21 * 3600)
                break;
            int h1, m1, s1, h2, m2, s2;
            int t = user.get(i).arrive;
            h1 = t / 3600;
            t %= 3600;
            m1 = t / 60;
            t %= 60;
            s1 = t;
            t = user.get(i).serve;
            h2 = t / 3600;
            t %= 3600;
            m2 = t / 60;
            t %= 60;
            s2 = t;
            System.out.printf("%02d:%02d:%02d %02d:%02d:%02d %d\n", h1, m1, s1, h2, m2, s2,
                    (user.get(i).wait + 30) / 60);
        }
        for (int i = 0; i < k; i++) {
            if (i != k - 1)
                System.out.printf("%d ", table.get(i).num);
            else
                System.out.printf("%d", table.get(i).num);
        }
    }

    private static void updateInfo(Integer userID, Integer tableID) {

        user.get(userID).serve = Math.max(user.get(userID).arrive, table.get(tableID).freeTime);

        user.get(userID).wait = user.get(userID).serve - user.get(userID).arrive;
        table.get(tableID).num++;
        table.get(tableID).freeTime = user.get(userID).serve + Math.min(user.get(userID).process, 2 * 3600);
    }

    private static int calTime(String[] times) {
        int h = Integer.parseInt(times[0]);
        int m = Integer.parseInt(times[1]);
        int s = Integer.parseInt(times[2]);

        return h * 3600 + m * 60 + s;
    }
}

/*
 * 运动员类
 */
class Node {
    int arrive, process, tag;// 到达时间、打球时间和VIP标志
    int serve = Integer.MAX_VALUE;
    int wait = Integer.MAX_VALUE;// 服务开始时间和等待时间

    public Node(int arrive, int process, int tag) {
        super();
        this.arrive = arrive;
        this.process = process;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Node [arrive=" + arrive + ", process=" + process + ", tag=" + tag + ", serve=" + serve + ", wait="
                + wait + "]";
    }
}

class Table {
    int tag;// vip标志
    int freeTime, num;// 空闲时间和服务数

    public Table(int tag, int freeTime, int num) {
        super();
        this.tag = tag;
        this.freeTime = freeTime;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Table [tag=" + tag + ", freeTime=" + freeTime + ", num=" + num + "]";
    }

}
