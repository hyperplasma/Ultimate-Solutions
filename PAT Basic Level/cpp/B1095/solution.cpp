#include <iostream>
#include <cstring>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

const int MAXN = 10010;

int n, m;
struct Student {
    string str;
    int score;
    int level, pos, date, id;
} stu[MAXN];
struct Position {
    int pos, cnt;
};
vector <Student> v_level[3];
unordered_map<int, vector<Student> > mp_pos;
unordered_map<int, vector<Student> > mp_date;

bool cmp(Student a, Student b) {
    if (a.score != b.score) return a.score > b.score;
    return a.str < b.str;
}

bool cmp_pos(Position a, Position b) {
    if (a.cnt != b.cnt) return a.cnt > b.cnt;
    return a.pos < b.pos;
}

int main() {
    scanf("%d%d", &n, &m);
    string str;
    for (int i = 0; i < n; ++i) {
        int score, level, pos, date, id;
        cin >> str >> score;

        if (str[0] == 'T') level = 0;
        else if (str[0] == 'A') level = 1;
        else level = 2;
        pos = stoi(str.substr(1, 3));
        date = stoi(str.substr(4, 6));
        id = stoi(str.substr(10));

        stu[i] = {str, score, level, pos, date, id};
        v_level[level].push_back(stu[i]);
        mp_pos[pos].push_back(stu[i]);
        mp_date[date].push_back(stu[i]);
    }

    string c;
    for (int idx = 1; idx <= m; ++idx) {
        int type;
        scanf("%d", &type);
        printf("Case %d: %d ", idx, type);
        if (type == 1) {
            cin >> c;
            cout << c << endl;
            int level;
            if (c == "T") level = 0;
            else if (c == "A") level = 1;
            else level = 2;

            vector <Student> &v = v_level[level];
            if (v.empty()) {
                printf("NA\n");
                continue;
            }
            sort(v.begin(), v.end(), cmp);
            for (Student &it: v)
                printf("%s %d\n", it.str.c_str(), it.score);
        } else if (type == 2) {
            int pos;
            scanf("%d", &pos);
            printf("%d\n", pos);

            vector <Student> &v = mp_pos[pos];
            if (v.empty()) {
                printf("NA\n");
                continue;
            }

            int sum = 0;
            for (Student &it: v) sum += it.score;
            printf("%d %d\n", v.size(), sum);
        } else {
            int date;
            scanf("%d", &date);
            printf("%06d\n", date);

            vector <Student> &v = mp_date[date];
            if (v.empty()) {
                printf("NA\n");
                continue;
            }

            int cnt[1010] = {0};
            for (Student &it: v) cnt[it.pos]++;
            vector <Position> res;
            for (int pos = 100; pos < 1010; ++pos)
                if (cnt[pos]) res.push_back({pos, cnt[pos]});

            sort(res.begin(), res.end(), cmp_pos);
            for (auto &it: res)
                printf("%d %d\n", it.pos, it.cnt);
        }
    }

    return 0;
}
