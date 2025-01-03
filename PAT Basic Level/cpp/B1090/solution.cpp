#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010;

int n, m, k;
vector <pair<int, int>> danger;

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; i++) {
        int t1, t2;
        scanf("%d %d", &t1, &t2);
        danger.push_back({t1, t2});
    }

    while (m--) {
        bool flag = true;
        int st[N] = {0};

        scanf("%d", &k);
        for (int i = 0; i < k; i++) {
            int t;
            scanf("%d", &t);
            st[t]++;
        }

        for (int i = 0; i < danger.size(); i++)
            if (st[danger[i].first] > 0 && st[danger[i].second] > 0)
                flag = 0;

        printf("%s\n", flag ? "Yes" : "No");
    }

    return 0;
}
