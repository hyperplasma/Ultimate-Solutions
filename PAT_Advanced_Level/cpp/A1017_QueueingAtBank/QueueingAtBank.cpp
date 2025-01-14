#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>

using namespace std;

const int MAXN = 10010, INF = 1e7 + 10;

int n, k;

struct Person {
    int arrive_time;
    int service_time;

    bool operator<(const Person &t) const {
        return arrive_time < t.arrive_time;
    }
} persons[MAXN];

priority_queue<int, vector<int>, greater<int> > windows;

int main() {
    cin >> n >> k;
    for (int i = 0; i < k; ++i) windows.push(8 * 3600);
    for (int i = 0; i < n; ++i) {
        int hh, mm, ss, service_minute;
        scanf("%d:%d:%d %d", &hh, &mm, &ss, &service_minute);

        persons[i].arrive_time = hh * 3600 + mm * 60 + ss;
        persons[i].service_time = service_minute * 60;
    }

    sort(persons, persons + n);

    int sum = 0, cnt = 0;
    for (int i = 0; i < n; ++i) {
        auto person = persons[i];
        auto window = windows.top();
        windows.pop();

        if (person.arrive_time > 17 * 3600) break;

        int start_time = max(window, person.arrive_time);
        sum += start_time - person.arrive_time;
        cnt++;

        window = start_time + min(person.service_time, 1 * 3600); // 从开始办理时间开始算！！！
        windows.push(window);
    }

    printf("%.1lf", sum / 60.0 / cnt);
    return 0;
}

