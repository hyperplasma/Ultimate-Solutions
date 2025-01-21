#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <queue>

using namespace std;

const int N = 10010, M = 110, INF = 1000000;

int n, k, m;

struct Person {  // 球员
    int arrive_time, play_time;
    int start_time, waiting_time;

    bool operator<(const Person &t) const {  // sort排序
        if (start_time != t.start_time) return start_time < t.start_time;
        return arrive_time < t.arrive_time;
    }

    bool operator>(const Person &t) const {  // 优先队列中比较大小
        return arrive_time > t.arrive_time;
    }
};

struct Table {  // 球桌
    int id;
    int end_time;

    bool operator>(const Table &t) const {  // 优先队列中比较大小
        if (end_time != t.end_time) return end_time > t.end_time;
        return id > t.id;
    }
};

bool is_vip_table[M];
int table_cnt[M];
vector <Person> persons;

void assign(priority_queue <Person, vector<Person>, greater<Person>> &ps,
            priority_queue <Table, vector<Table>, greater<Table>> &ts) {
    auto p = ps.top();
    ps.pop();
    auto t = ts.top();
    ts.pop();

    p.waiting_time = round((t.end_time - p.arrive_time) / 60.0);
    p.start_time = t.end_time;
    table_cnt[t.id]++;
    persons.push_back(p);
    ts.push({t.id, t.end_time + p.play_time});
}

string get_time(int secs) {
    char str[20];
    sprintf(str, "%02d:%02d:%02d", secs / 3600, secs % 3600 / 60, secs % 60);
    return str;
}

int main() {
    cin >> n;

    priority_queue <Person, vector<Person>, greater<Person>> normal_persons;
    priority_queue <Person, vector<Person>, greater<Person>> vip_persons;

    normal_persons.push({INF});
    vip_persons.push({INF});

    for (int i = 0; i < n; i++) {
        int hour, minute, second;
        int play_time, is_vip;
        scanf("%d:%d:%d %d %d", &hour, &minute, &second, &play_time, &is_vip);

        int secs = hour * 3600 + minute * 60 + second;
        play_time = min(play_time, 120);
        play_time *= 60;

        if (is_vip) vip_persons.push({secs, play_time});
        else normal_persons.push({secs, play_time});
    }

    priority_queue <Table, vector<Table>, greater<Table>> normal_tables;
    priority_queue <Table, vector<Table>, greater<Table>> vip_tables;
    normal_tables.push({-1, INF});
    vip_tables.push({-1, INF});

    cin >> k >> m;
    for (int i = 0; i < m; i++) {
        int id;
        cin >> id;
        is_vip_table[id] = true;
    }

    for (int i = 1; i <= k; i++)
        if (is_vip_table[i]) vip_tables.push({i, 8 * 3600});
        else normal_tables.push({i, 8 * 3600});

    while (normal_persons.size() > 1 || vip_persons.size() > 1) {
        auto np = normal_persons.top();
        auto vp = vip_persons.top();
        int arrive_time = min(np.arrive_time, vp.arrive_time);

        while (normal_tables.top().end_time < arrive_time) {  // O(klogk)
            auto t = normal_tables.top();
            normal_tables.pop();
            t.end_time = arrive_time;
            normal_tables.push(t);
        }
        while (vip_tables.top().end_time < arrive_time) {
            auto t = vip_tables.top();
            vip_tables.pop();
            t.end_time = arrive_time;
            vip_tables.push(t);
        }

        auto nt = normal_tables.top();
        auto vt = vip_tables.top();
        int end_time = min(nt.end_time, vt.end_time);

        if (end_time >= 21 * 3600) break;

        if (vp.arrive_time <= end_time && vt.end_time == end_time) {
            assign(vip_persons, vip_tables);
        } else if (np.arrive_time < vp.arrive_time) {
            if (nt > vt) assign(normal_persons, vip_tables);
            else assign(normal_persons, normal_tables);
        } else {
            if (nt > vt) assign(vip_persons, vip_tables);
            else assign(vip_persons, normal_tables);
        }
    }

    sort(persons.begin(), persons.end());

    for (auto &p: persons) {
        cout << get_time(p.arrive_time) << ' ' << get_time(p.start_time) << ' ';
        cout << p.waiting_time << endl;
    }

    cout << table_cnt[1];
    for (int i = 2; i <= k; i++) cout << ' ' << table_cnt[i];
    cout << endl;
    return 0;
}
