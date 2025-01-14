#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <unordered_map>

using namespace std;

struct Event {
    int time, status;

    bool operator<(const Event &t) const {
        return time < t.time;
    }
};

int n, m;
unordered_map <string, vector<Event>> cars;

int get(vector <Event> &v) {
    int res = 0;
    for (int i = 0; i < v.size(); i += 2)
        res += v[i + 1].time - v[i].time;
    return res;
}

int main() {
    scanf("%d%d", &n, &m);

    char id[10], status[10];
    for (int i = 0; i < n; ++i) {
        int hh, mm, ss;
        scanf("%s %d:%d:%d %s", id, &hh, &mm, &ss, status);

        int t = hh * 3600 + mm * 60 + ss;
        int s = 0;                        // in  0
        if (status[0] == 'o') s = 1;    // out 1

        cars[id].push_back({t, s});
    }

    vector <Event> events;

    for (auto &car: cars) {
        auto &v = car.second;
        sort(v.begin(), v.end());
        vector <Event> new_v;

        for (int i = 0; i < v.size(); ++i)
            if (v[i].status == 0) {
                if (i + 1 < v.size() && v[i + 1].status == 1) {
                    new_v.push_back(v[i]);
                    new_v.push_back(v[i + 1]);
                    ++i;
                }
            }

        v = new_v;
        for (auto i: v) events.push_back(i);
    }

    sort(events.begin(), events.end());

    int i = 0, sum = 0;
    while (m--) {
        int hh, mm, ss;
        scanf("%d:%d:%d", &hh, &mm, &ss);
        int t = hh * 3600 + mm * 60 + ss;

        for (; i < events.size() && events[i].time <= t; ++i) {
            if (events[i].status == 0) sum++;        // in
            else sum--;                                // out
        }

        printf("%d\n", sum);
    }

    int maxt = 0;
    for (auto &car: cars) {
        maxt = max(maxt, get(car.second));
    }

    vector <string> res;
    for (auto &car: cars)
        if (get(car.second) == maxt)
            res.push_back(car.first);

    sort(res.begin(), res.end());

    for (auto it: res) cout << it << " ";
    printf("%02d:%02d:%02d\n", maxt / 3600, maxt % 3600 / 60, maxt % 60);

    return 0;
}
