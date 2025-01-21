package PAT_A1033_To_Fill_or_Not_to_Fill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double tank = sc.nextDouble(), distance = sc.nextDouble(), avgDist = sc.nextDouble();
        int n = sc.nextInt();
        List<Station> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Station(sc.nextDouble(), sc.nextInt()));
        }
        sc.close();

        Collections.sort(list);
        if (distance == 0) {
            System.out.println("0.00");
            return;
        }
        if (list.get(0).getDist() != 0) {
            System.out.println("The maximum travel distance = 0.00");
            return;
        }

        int curStNum = 0;
        double curGas = 0;
        double curCost = 0;
        double maxDis = tank * avgDist;
        while (true) {
            boolean tag = false;
            boolean isCheaper = false;
            double cheapestPrice = Double.MAX_VALUE;
            int cheapestNum = 0;
            for (int i = curStNum + 1; i <= n; i++) {
                if (i == n || (list.get(i).getDist() - list.get(curStNum).getDist()) > maxDis) break;
                tag = true;
                if (list.get(i).getPrice() < list.get(curStNum).getPrice()) {
                    isCheaper = true;
                    double dist = list.get(i).getDist() - list.get(curStNum).getDist();
                    double needGas = dist / avgDist - curGas;
                    curGas = 0;
                    curCost += needGas * list.get(curStNum).getPrice();
                    curStNum = i;
                    break;
                }
                if (list.get(i).getPrice() < cheapestPrice) {
                    cheapestPrice = list.get(i).getPrice();
                    cheapestNum = i;
                }
            }

            if (!isCheaper && (distance - list.get(curStNum).getDist() <= maxDis)) {
                double dist = distance - list.get(curStNum).getDist();
                double needGas = dist / avgDist - curGas;
                curCost += needGas * list.get(curStNum).getPrice();
                System.out.printf("%.2f", curCost);
                return;
            }

            if (tag && !isCheaper) {
                double needGas = tank - curGas;
                curCost += (needGas * list.get(curStNum).getPrice());
                double dist = list.get(cheapestNum).getDist() - list.get(curStNum).getDist();
                curGas = tank - dist / avgDist;
                curStNum = cheapestNum;
            } else if (!tag) {
                System.out.print("The maximum travel distance = ");
                System.out.printf("%.2f", list.get(curStNum).getDist() + maxDis);
                return;
            }
        }
    }

    static class Station implements Comparable<Station> {
        private final double price;
        private final double dist;

        public Station(double price, double dist) {
            this.price = price;
            this.dist = dist;
        }

        @Override
        public int compareTo(Station s1) {
            return Double.compare(this.dist, s1.getDist());
        }

        public double getPrice() {
            return price;
        }

        public double getDist() {
            return dist;
        }
    }
}