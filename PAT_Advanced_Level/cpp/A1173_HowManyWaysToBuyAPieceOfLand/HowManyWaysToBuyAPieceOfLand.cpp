#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 10010;

int n, m, res = 0;
int w[N];    // [1, n]

int dfs(int k, int m) {
    int res = 0;

    if (k <= n && m - w[k] >= 0)
        res += 1 + dfs(k + 1, m - w[k]);

    return res;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) scanf("%d", &w[i]);

    for (int i = 1; i <= n; ++i) res += dfs(i, m);

    printf("%d", res);
    return 0;
}
