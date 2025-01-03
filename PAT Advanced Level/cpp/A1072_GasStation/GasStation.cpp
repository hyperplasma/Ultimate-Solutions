#include <iostream>
#include <cstring>
#include <cmath>

using namespace std;

const int N = 1020, INF = 0x3f3f3f3f;

int n, m, k, D;
int g[N][N];
int dist[N];
bool st[N];

int get(string s) {
    if (s[0] == 'G') return n + stoi(s.substr(1));
    return stoi(s);
}

void dijkstra(int S, int &mind, int &sumd) {
    memset(dist, 0x3f, sizeof dist);
    memset(st, false, sizeof st);
    dist[S] = 0;

    for (int i = 0; i < n + m; ++i) {
        int t = -1;
        for (int j = 1; j <= n + m; ++j)
            if (!st[j] && (t == -1 || dist[j] < dist[t])) t = j;

        st[t] = true;

        for (int j = 1; j <= n + m; ++j)
            dist[j] = min(dist[j], dist[t] + g[t][j]);
    }

    for (int i = 1; i <= n; ++i)
        if (dist[i] > D) {
            mind = -INF;
            return;
        }

    mind = INF, sumd = 0;
    for (int i = 1; i <= n; ++i) {
        mind = min(dist[i], mind);
        sumd += dist[i];
    }
}

int main() {
    memset(g, 0x3f, sizeof g);

    cin >> n >> m >> k >> D;
    while (k--) {
        string a, b;
        int d;
        cin >> a >> b >> d;

        int x = get(a), y = get(b);
        g[x][y] = g[y][x] = min(d, g[x][y]);
    }

    int res = -1, mind = 0, sumd = INF;
    for (int i = n + 1; i <= n + m; ++i) {
        int t1, t2;
        dijkstra(i, t1, t2);

        if (t1 > mind) {
            res = i;
            mind = t1;
            sumd = t2;
        } else if (t1 == mind && t2 < sumd) {
            res = i;
            sumd = t2;
        }
    }

    if (res == -1) printf("No Solution\n");
    else printf("G%d\n%.1lf %.1lf\n", res - n, (double) mind, (double) sumd / n + 1e-8);

    return 0;
}
