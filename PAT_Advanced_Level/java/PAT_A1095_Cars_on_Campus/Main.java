package PAT_A1095_Cars_on_Campus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试点1、2、4、5超时
 */
public class Main {
    static int n, m;
    static Map<String, List<Event>> cars = new HashMap<>();

    static int get(List<Event> v) {
        int res = 0;
        for (int i = 0; i < v.size(); i += 2) {
            res += v.get(i + 1).time - v.get(i).time;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            String id = line[0];
            String[] timeParts = line[1].split(":");
            int hh = Integer.parseInt(timeParts[0]);
            int mm = Integer.parseInt(timeParts[1]);
            int ss = Integer.parseInt(timeParts[2]);
            String status = line[2];

            int t = hh * 3600 + mm * 60 + ss;
            int s = 0;
            if (status.charAt(0) == 'o') s = 1;

            cars.computeIfAbsent(id, k -> new ArrayList<>()).add(new Event(t, s));
        }

        List<Event> events = new ArrayList<>();
        for (Map.Entry<String, List<Event>> entry : cars.entrySet()) {
            List<Event> v = entry.getValue();
            Collections.sort(v);
            List<Event> newV = new ArrayList<>();

            for (int i = 0; i < v.size(); i++) {
                if (v.get(i).status == 0) {
                    if (i + 1 < v.size() && v.get(i + 1).status == 1) {
                        newV.add(v.get(i));
                        newV.add(v.get(i + 1));
                        i++;
                    }
                }
            }

            v.clear();
            v.addAll(newV);
            events.addAll(v);
        }

        Collections.sort(events);

        int i = 0, sum = 0;
        while (m-- > 0) {
            String[] timeParts = br.readLine().split(":");
            int hh = Integer.parseInt(timeParts[0]);
            int mm = Integer.parseInt(timeParts[1]);
            int ss = Integer.parseInt(timeParts[2]);
            int t = hh * 3600 + mm * 60 + ss;

            while (i < events.size() && events.get(i).time <= t) {
                if (events.get(i).status == 0) sum++;
                else sum--;
                i++;
            }

            System.out.println(sum);
        }

        int maxTime = 0;
        for (Map.Entry<String, List<Event>> entry : cars.entrySet()) {
            maxTime = Math.max(maxTime, get(entry.getValue()));
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<Event>> entry : cars.entrySet()) {
            if (get(entry.getValue()) == maxTime) {
                res.add(entry.getKey());
            }
        }

        Collections.sort(res);

        for (String it : res) System.out.print(it + " ");
        System.out.printf("%02d:%02d:%02d\n", maxTime / 3600, maxTime % 3600 / 60, maxTime % 60);
    }
}

class Event implements Comparable<Event> {
    int time, status;

    public Event(int time, int status) {
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(Event other) {
        return Integer.compare(this.time, other.time);
    }
}