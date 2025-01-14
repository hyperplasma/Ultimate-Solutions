#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 510;

int n, m;
bool g[N][N], st[N];    // [1, n]
int deg[N];

int dfs(int u) {
    st[u] = true;

    int res = 1;
    for (int i = 1; i <= n; ++i)
        if (!st[i] && g[u][i])
            res += dfs(i);

    return res;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; ++i) {
        int a, b;
        scanf("%d%d", &a, &b);
        g[a][b] = g[b][a] = true;
        deg[a]++;
        deg[b]++;
    }

    for (int i = 1; i <= n; ++i) {
        if (i > 1) printf(" ");
        printf("%d", deg[i]);
    }
    printf("\n");

    int num = dfs(1);
    if (num < n) printf("Non-Eulerian\n");
    else {
        int cnt = 0;
        for (int i = 1; i <= n; ++i)
            if (deg[i] % 2 == 1) cnt++;

        if (cnt == 0) printf("Eulerian\n");
        else if (cnt == 2) printf("Semi-Eulerian\n");
        else printf("Non-Eulerian\n");
    }
    return 0;
}
