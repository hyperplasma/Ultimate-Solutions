#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

const int N = 24 * 60 * 31 + 10;

int n;
int cost[24];
double sum[N];

struct Record {
    int time;
    string state;
    int month;
    string format_time;

    bool operator<(const Record &t) const {
        return time < t.time;
    }
};

map <string, vector<Record>> persons;

int main() {
    for (int i = 0; i < 24; ++i)
        cin >> cost[i];
    for (int i = 1; i < N; ++i)
        sum[i] = sum[i - 1] + cost[(i - 1) % 1440 / 60] / 100.0;

    cin >> n;
    char name[25], state[25], format_time[25];
    for (int i = 0; i < n; ++i) {
        int month, day, hour, minute;
        scanf("%s %d:%d:%d:%d %s", name, &month, &day, &hour, &minute, state);

        sprintf(format_time, "%02d:%02d:%02d", day, hour, minute);
        int time = (day - 1) * 24 * 60 + hour * 60 + minute;
        persons[name].push_back({time, state, month, format_time});
    }

    for (auto &person: persons) {
        auto records = person.second;
        sort(records.begin(), records.end());
        double total = 0;

        for (int i = 0; i < records.size() - 1; ++i)
            if (records[i].state == "on-line" && records[i + 1].state == "off-line") {
                if (total == 0) printf("%s %02d\n", person.first.c_str(), records[i].month);
                cout << records[i].format_time << " " << records[i + 1].format_time << " ";

                int gap = records[i + 1].time - records[i].time;
                double money = sum[records[i + 1].time] - sum[records[i].time];
                printf("%d $%.2f\n", gap, money);
                total += money;
            }

        if (total) printf("Total amount: $%.2f\n", total);
    }

    return 0;
}
