#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <unordered_set>
#include <vector>

using namespace std;

const int N = 210, INF = 0x3f3f3f3f;

int n, m;
int g[N][N];

int main() {
    cin >> n >> m;

    for (int i = 0; i < m; ++i) {
        int a, b, w;
        cin >> a >> b >> w;
        g[a][b] = g[b][a] = w;
    }

    int Q;
    cin >> Q;

    int mind = INF, minnum = 0;
    for (int num = 1; num <= Q; ++num) {
        vector<int> v;
        unordered_set<int> st;

        int k;
        cin >> k;
        for (int i = 0; i < k; ++i) {
            int x;
            cin >> x;
            v.push_back(x);
            st.insert(x);
        }

        int dist = 0;
        for (int i = 0; i < v.size() - 1; ++i) {
            if (!g[v[i]][v[i + 1]]) {
                dist = -1;
                break;
            }

            dist += g[v[i]][v[i + 1]];
        }

        int flag = 2;
        if (st.size() < n || *v.begin() != *(v.end() - 1) || dist == -1)
            flag = 0;
        else if (v.size() != n + 1)
            flag = 1;

        if (flag) {
            if (dist < mind) {
                mind = dist;
                minnum = num;
            }
        }

        printf("Path %d: ", num);
        if (dist == -1) printf("NA ");
        else printf("%d ", dist);

        if (flag == 2) printf("(TS simple cycle)\n");
        else if (flag == 1) printf("(TS cycle)\n");
        else printf("(Not a TS cycle)\n");
    }

    printf("Shortest Dist(%d) = %d\n", minnum, mind);

    return 0;
}
