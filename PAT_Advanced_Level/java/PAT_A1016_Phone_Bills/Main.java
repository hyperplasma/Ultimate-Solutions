package PAT_A1016_Phone_Bills;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/**
 * 2个测试点超时
 */
public class Main {
    static int totalFee = 0;
    static int[] fee = new int[24];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] fee1 = reader.readLine().split(" ");
        for (int i = 0; i < fee.length; i++) {
            fee[i] = Integer.parseInt(fee1[i]);
            totalFee += fee[i];
        }

        int n = Integer.parseInt(reader.readLine());
        Map<String, ArrayList<Record>> map = new TreeMap<>(Comparator.naturalOrder());

        for (int i = 0; i < n; i++) {
            String[] str = reader.readLine().split(" ");
            Record record = new Record(str[0], str[1], str[2]);
            if (!map.containsKey(str[0]))
                map.put(str[0], new ArrayList<>());
            map.get(str[0]).add(record);
        }

        for (var entry : map.entrySet()) {
            ArrayList<Record> list = entry.getValue();
            Collections.sort(list);
            double singleAmount = 0;
            double totalAmount = 0;
            Record lastRecord = list.get(0);
            StringBuilder output = new StringBuilder(String.format("%s %02d\n", entry.getKey(), lastRecord.month));

            for (Record currentRecord : list) {
                if (currentRecord.status.equals("on-line")) {
                    lastRecord = currentRecord;
                    continue;
                } else {
                    if (lastRecord.status.equals("on-line")) {
                        int minute = currentRecord.relativeTime - lastRecord.relativeTime;
                        singleAmount = (currentRecord.relativeFee - lastRecord.relativeFee) / 100.0;
                        totalAmount += singleAmount;
                        output.append(String.format("%s %s %d $%.2f\n",
                                lastRecord.time.substring(3), currentRecord.time.substring(3), minute, singleAmount));
                    }
                }
                lastRecord = currentRecord;
            }
            output.append(String.format("Total amount: $%.2f", totalAmount));
            if (totalAmount > 0)
                System.out.println(output);
        }

    }

    static class Record implements Comparable<Record> {
        String id;
        String time;
        int month;
        int day;
        int hour;
        int minute;
        String status;
        double relativeFee;
        int relativeTime;

        public Record(String id, String time, String status) {
            this.id = id;
            this.time = time;
            String[] str = time.split(":");
            this.month = Integer.parseInt(str[0]);
            this.day = Integer.parseInt(str[1]);
            this.hour = Integer.parseInt(str[2]);
            this.minute = Integer.parseInt(str[3]);
            this.status = status;
            this.relativeTime = day * 1440 + hour * 60 + minute;
            this.relativeFee += minute * fee[hour];
            for (int i = 0; i < hour; i++)
                this.relativeFee += fee[i] * 60;
            this.relativeFee += day * 60 * totalFee;
        }

        @Override
        public int compareTo(Record r1) {
            return this.relativeTime - r1.relativeTime;
        }
    }
}

