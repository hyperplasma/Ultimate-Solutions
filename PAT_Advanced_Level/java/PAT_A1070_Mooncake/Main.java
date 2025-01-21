package PAT_A1070_Mooncake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Mooncake implements Comparable<Mooncake> {
        double num;
        double price;
        double unitPrice;

        public Mooncake(double num, double price, double unitPrice) {
            this.num = num;
            this.price = price;
            this.unitPrice = unitPrice;
        }

        @Override
        public int compareTo(Mooncake o) {
            return o.unitPrice > this.unitPrice ? 1 : -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        double demandNum = Double.parseDouble(s[1]);

        ArrayList<Mooncake> list = new ArrayList<>();
        String[] s1 = br.readLine().split(" "), s2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            double num = Double.parseDouble(s1[i]);
            double price = Double.parseDouble(s2[i]);
            double value = price / num;
            Mooncake mooncake = new Mooncake(num, price, value);
            list.add(mooncake);
        }

        Collections.sort(list);
        double res = 0;
        for (int i = 0; i < n; i++) {
            if (demandNum >= list.get(i).num) {
                res += list.get(i).price;
                demandNum -= list.get(i).num;
            } else {
                res += list.get(i).unitPrice * demandNum;
                break;
            }
        }
        System.out.printf("%.2f", res);
    }
}






