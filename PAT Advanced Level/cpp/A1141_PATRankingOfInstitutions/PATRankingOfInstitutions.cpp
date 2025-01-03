#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>
#include <vector>

using namespace std;

const int N = 100010;

int n;

struct School {
    string id;
    double total;
    int num, r;

    bool operator<(const School &t) const {
        if ((int) total != (int) t.total) return (int) total > (int) t.total;
        else if (num != t.num) return num < t.num;
        else return id < t.id;
    }
};

unordered_map <string, School> mp;
vector <School> v;

int main() {
    scanf("%d", &n);

    string s, id;
    int score;
    for (int i = 0; i < n; ++i) {
        cin >> s >> score >> id;
        for (auto &c: id) c = tolower(c);

        mp[id].id = id;
        mp[id].num++;

        if (s[0] == 'B') mp[id].total += score * 1.0 / 1.5;
        else if (s[0] == 'A') mp[id].total += score * 1.0;
        else mp[id].total += score * 1.5;
    }

    for (auto &it: mp) v.push_back(it.second);
    sort(v.begin(), v.end());

    printf("%d\n", v.size());

    v[0].r = 1;
    printf("%d %s %d %d\n", v[0].r, v[0].id.c_str(), (int) v[0].total, v[0].num);
    for (int i = 1; i < v.size(); ++i) {
        if ((int) v[i].total == (int) v[i - 1].total) v[i].r = v[i - 1].r;
        else v[i].r = i + 1;

        printf("%d %s %d %d\n", v[i].r, v[i].id.c_str(), (int) v[i].total, v[i].num);
    }

    return 0;
}
