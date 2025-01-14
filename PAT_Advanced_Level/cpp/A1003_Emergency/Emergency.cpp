#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 510, INF = 0x3f3f3f3f;

int n, m, S, T;
int g[N][N], w[N];        // [0, n - 1]
int dist[N], sum[N], cnt[N];
bool st[N];

void dijkstra() {
    memset(dist, 0x3f, sizeof dist);
    memset(st, false, sizeof st);
    memset(sum, 0, sizeof sum);
    memset(cnt, 0, sizeof cnt);
    dist[S] = 0;
    sum[S] = w[S];
    cnt[S] = 1;

    for (int i = 0; i < n - 1; ++i) {
        int t = -1;
        for (int j = 0; j < n; ++j)
            if (!st[j] && (t == -1 || dist[j] < dist[t]))
                t = j;

        st[t] = true;

        for (int j = 0; j < n; ++j) {
            if (dist[j] > dist[t] + g[t][j]) {
                dist[j] = dist[t] + g[t][j];
                sum[j] = sum[t] + w[j];
                cnt[j] = cnt[t];
            } else if (dist[j] == dist[t] + g[t][j]) {
                cnt[j] += cnt[t];
                if (sum[j] < sum[t] + w[j]) sum[j] = sum[t] + w[j];
            }
        }
    }
}

int main() {
    memset(g, 0x3f, sizeof(g));

    scanf("%d%d%d%d", &n, &m, &S, &T);
    for (int i = 0; i < n; ++i) scanf("%d", &w[i]);
    for (int i = 0; i < m; ++i) {
        int a, b, len;
        scanf("%d%d%d", &a, &b, &len);
        g[a][b] = g[b][a] = min(g[a][b], len);
    }

    dijkstra();
    printf("%d %d\n", cnt[T], sum[T]);

    return 0;
}
