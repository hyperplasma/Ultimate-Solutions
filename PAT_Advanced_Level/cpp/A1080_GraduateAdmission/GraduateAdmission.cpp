#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 40100;

int n, m, k;        // stu:[0, n-1] school:[0, m-1]

struct School {
    int cnt;
    vector<int> v;
} sch[N];

struct Student {
    int id;
    int Ge, Gi, total;
    int r;
    vector<int> v;

    bool operator<(const Student &t) const {
        if (total != t.total) return total > t.total;
        if (Ge != t.Ge) return Ge > t.Ge;
    }

    bool operator==(const Student &t) const {
        return Ge == t.Ge && Gi == t.Gi;
    }
} stu[N];

int wish[N];

int main() {
    scanf("%d%d%d", &n, &m, &k);
    for (int i = 0; i < m; ++i) scanf("%d", &sch[i].cnt);

    for (int i = 0; i < n; ++i) {
        scanf("%d%d", &stu[i].Ge, &stu[i].Gi);
        stu[i].id = i;
        stu[i].total = stu[i].Ge + stu[i].Gi;

        for (int j = 0; j < k; ++j) {
            int t;
            scanf("%d", &t);
            stu[i].v.push_back(t);
        }
    }

    sort(stu, stu + n);

    memset(wish, -1, sizeof wish);
    for (int i = 0; i < n;) {
        int j = i + 1;
        while (j < n && stu[i] == stu[j]) j++;

        for (int t = i; t < j; ++t)
            for (int u = 0; u < k; ++u) {
                int w = stu[t].v[u];
                if (sch[w].cnt > (int) sch[w].v.size()) {
                    wish[t] = w;
                    break;
                }
            }

        for (int t = i; t < j; ++t)
            if (wish[t] != -1)
                sch[wish[t]].v.push_back(stu[t].id);

        i = j;
    }

    for (int i = 0; i < m; ++i) {
        if (!sch[i].v.empty()) {
            sort(sch[i].v.begin(), sch[i].v.end());
            for (int j = 0; j < (int) sch[i].v.size(); ++j) {
                if (j > 0) printf(" ");
                printf("%d", sch[i].v[j]);
            }
        }
        printf("\n");
    }

    return 0;
}
