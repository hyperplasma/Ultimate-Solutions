#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

const int N = 1010, M = N * 1000;

int n, m;
int h[N], e[M], ne[M], idx;
bool st[N];

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

int bfs(int u) {
    memset(st, false, sizeof st);

    queue<int> q;
    q.push(u);
    st[u] = true;

    int res = 0;
    for (int step = 0; step < m; ++step) {
        int size = q.size();
        res += size;
        while (size--) {
            int t = q.front();
            q.pop();
            for (int i = h[t]; ~i; i = ne[i]) {
                int j = e[i];
                if (!st[j]) {
                    st[j] = true;
                    q.push(j);
                }
            }
        }
    }

    return res + q.size() - 1;
}

int main() {
    memset(h, -1, sizeof h);

    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) {
        int k;
        scanf("%d", &k);
        while (k--) {
            int a;
            scanf("%d", &a);
            add(a, i);
        }
    }

    int k;
    scanf("%d", &k);
    while (k--) {
        int a;
        scanf("%d", &a);
        printf("%d\n", bfs(a));
    }
    return 0;
}
