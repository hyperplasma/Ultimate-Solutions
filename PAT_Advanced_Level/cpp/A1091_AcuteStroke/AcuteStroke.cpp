#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <queue>

using namespace std;

const int M = 1286, N = 128, L = 60;

int m, n, l, T;
int g[L][M][N];        // [l] [m] [n]
struct Node {
    int x, y, z;
};

int d[][3] = {
        {1,  0,  0},
        {-1, 0,  0},
        {0,  1,  0},
        {0,  -1, 0},
        {0,  0,  1},
        {0,  0,  -1},
};

int BFS(Node u) {
    queue <Node> q;
    q.push(u);
    g[u.x][u.y][u.z] = 0;

    int cnt = 1;
    while (!q.empty()) {
        auto p = q.front();
        q.pop();

        for (int i = 0; i < 6; ++i) {
            Node v;
            v.x = p.x + d[i][0], v.y = p.y + d[i][1], v.z = p.z + d[i][2];
            if (v.x >= 0 && v.x < l && v.y >= 0 && v.y < m &&
                v.z >= 0 && v.z < n && g[v.x][v.y][v.z]) {
                cnt++;
                g[v.x][v.y][v.z] = 0;
                q.push(v);
            }
        }
    }

    return cnt;
}

int main() {
    scanf("%d%d%d%d", &m, &n, &l, &T);

    for (int i = 0; i < l; ++i)
        for (int j = 0; j < m; ++j)
            for (int k = 0; k < n; ++k)
                scanf("%d", &g[i][j][k]);

    int sum = 0;
    for (int i = 0; i < l; ++i)
        for (int j = 0; j < m; ++j)
            for (int k = 0; k < n; ++k)
                if (g[i][j][k]) {
                    int cnt = BFS({i, j, k});
                    if (cnt >= T) sum += cnt;
                }

    printf("%d\n", sum);

    return 0;
}
