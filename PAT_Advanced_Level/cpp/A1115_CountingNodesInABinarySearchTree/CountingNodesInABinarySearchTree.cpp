#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1010;

int n;        // [1, n]
int l[N], r[N], w[N], idx;    // 左<=，右>
int depth[N], bottom, cnt1, cnt2;

void insert(int &u, int x, int d) {
    if (!u) {
        u = ++idx;
        w[u] = x;
        depth[u] = d;
        bottom = max(bottom, d);
    } else if (x <= w[u]) {
        insert(l[u], x, d + 1);
    } else insert(r[u], x, d + 1);
}

void dfs(int u) {
    if (u) {
        if (depth[u] == bottom) cnt1++;
        else if (depth[u] == bottom - 1) cnt2++;

        dfs(l[u]);
        dfs(r[u]);
    }
}

int main() {
    scanf("%d", &n);

    int root = 0;
    for (int i = 0; i < n; ++i) {
        int x;
        scanf("%d", &x);
        insert(root, x, 0);
    }

    dfs(root);
    printf("%d + %d = %d\n", cnt1, cnt2, cnt1 + cnt2);

    return 0;
}
