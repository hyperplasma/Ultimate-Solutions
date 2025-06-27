#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>
#include <vector>

using namespace std;

const int N = 10010, M = 7;

int n, Q, m;
int fullscore[M];

struct Student {
    int id, score[M], pnum, total, r;
    bool flag, is_submitted[M], has_p[M];

    bool operator<(const Student &t) const {
        if (total != t.total) return total > t.total;
        else if (pnum != t.pnum) return pnum > t.pnum;
        else return id < t.id;
    }
};

unordered_map<int, Student> mp;
vector<Student> v;

int main() {
    scanf("%d%d%d", &n, &Q, &m);
    for (int i = 1; i <= Q; ++i) scanf("%d", &fullscore[i]);
    for (int i = 0; i < m; ++i) {
        int id, pid, score;
        scanf("%d%d%d", &id, &pid, &score);

        mp[id].id = id;
        if (score != -1) {
            mp[id].score[pid] = max(score, mp[id].score[pid]);
            mp[id].is_submitted[pid] = true;
            if (!mp[id].has_p[pid] && score == fullscore[pid]) {
                mp[id].pnum++;
                mp[id].has_p[pid] = true;
            }
            mp[id].flag = true;
        } else {
            mp[id].is_submitted[pid] = true;
            mp[id].score[pid] = max(0, mp[id].score[pid]);
        }
    }

    for (auto &it: mp)
        if (it.second.flag) {
            auto &stu = it.second;
            for (int i = 1; i <= Q; ++i)
                stu.total += stu.score[i];
            v.push_back(stu);
        }

    sort(v.begin(), v.end());

    v[0].r = 1;

    for (int i = 0; i < (int) v.size(); ++i) {
        if (i > 0) {
            if (v[i].total == v[i - 1].total) v[i].r = v[i - 1].r;
            else v[i].r = i + 1;
        }

        printf("%d %05d %d", v[i].r, v[i].id, v[i].total);
        for (int j = 1; j <= Q; ++j) {
            if (!v[i].is_submitted[j]) printf(" -");
            else printf(" %d", v[i].score[j]);
        }
        printf("\n");
    }

    return 0;
}
