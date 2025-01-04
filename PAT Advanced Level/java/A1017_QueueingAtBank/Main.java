package A1017_QueueingAtBank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static final int OPEN_TIME = 8 * 3600;
    static final int CLOSE_TIME = 17 * 3600;

    static class Person implements Comparable<Person> {
        int arriveTime;
        int serviceTime;

        Person(int arriveTime, int serviceTime) {
            this.arriveTime = arriveTime;
            this.serviceTime = serviceTime;
        }

        @Override
        public int compareTo(Person t) {
            return Integer.compare(this.arriveTime, t.arriveTime);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> windows = new PriorityQueue<>();
        for (int i = 0; i < k; ++i) {
            windows.add(OPEN_TIME);
        }

        Person[] persons = new Person[n];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            String[] timeParts = st.nextToken().split(":");
            int hh = Integer.parseInt(timeParts[0]);
            int mm = Integer.parseInt(timeParts[1]);
            int ss = Integer.parseInt(timeParts[2]);
            int serviceMinute = Integer.parseInt(st.nextToken());

            int arriveTime = hh * 3600 + mm * 60 + ss;
            int serviceTime = serviceMinute * 60;
            persons[i] = new Person(arriveTime, serviceTime);
        }

        Arrays.sort(persons);

        int sum = 0, cnt = 0;
        for (int i = 0; i < n; ++i) {
            Person person = persons[i];
            int window = windows.poll();

            if (person.arriveTime > CLOSE_TIME) {
                break;
            }

            int startTime = Math.max(window, person.arriveTime);
            sum += startTime - person.arriveTime;
            cnt++;

            window = startTime + Math.min(person.serviceTime, 3600); // 从开始办理时间开始算
            windows.add(window);
        }

        System.out.printf("%.1f", sum / 60.0 / cnt);
    }
}
