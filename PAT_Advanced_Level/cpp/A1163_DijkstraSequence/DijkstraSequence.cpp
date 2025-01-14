#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1010, INF = 0x3f3f3f3f;

int n, m;    // [1, n]
int g[N][N], seq[N];
int dist[N];
bool st[N];

bool dijkstra() {
    memset(dist, 0x3f, sizeof dist);
    memset(st, false, sizeof st);
    dist[seq[0]] = 0;

    for (int i = 0; i < n; ++i) {
        int t = seq[i];
        for (int j = 1; j <= n; ++j)
            if (!st[j] && dist[j] < dist[t])
                return false;

        st[t] = true;

        for (int j = 1; j <= n; ++j)
            dist[j] = min(dist[j], dist[t] + g[t][j]);
    }
    return true;
}

int main() {
    memset(g, 0x3f, sizeof g);

    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; ++i) {
        int a, b, w;
        scanf("%d%d%d", &a, &b, &w);
        g[a][b] = g[b][a] = min(g[a][b], w);
    }

    int k;
    scanf("%d", &k);
    while (k--) {
        for (int i = 0; i < n; ++i) scanf("%d", &seq[i]);

        if (dijkstra()) printf("Yes\n");
        else printf("No\n");
    }

    return 0;
}
