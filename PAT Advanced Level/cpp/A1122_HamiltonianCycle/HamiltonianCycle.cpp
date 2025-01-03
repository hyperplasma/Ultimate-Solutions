#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 210;

int n, m, k;
bool g[N][N];
int seq[N], cnt[N];

bool check() {
    if (seq[0] != seq[k - 1]) return false;

    memset(cnt, 0, sizeof(cnt));
    for (int i = 0; i < k - 1; ++i) {
        if (!g[seq[i]][seq[i + 1]]) return false;
        cnt[seq[i]]++;
    }

    for (int i = 1; i <= n; ++i)
        if (cnt[i] != 1) return false;

    return true;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; ++i) {
        int a, b;
        scanf("%d%d", &a, &b);
        g[a][b] = g[b][a] = true;
    }

    int Q;
    scanf("%d", &Q);
    while (Q--) {
        scanf("%d", &k);
        for (int i = 0; i < k; ++i) scanf("%d", &seq[i]);

        if (check()) printf("YES\n");
        else printf("NO\n");
    }

    return 0;
}
