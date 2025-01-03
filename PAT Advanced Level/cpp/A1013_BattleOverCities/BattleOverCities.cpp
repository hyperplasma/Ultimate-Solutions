#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1010, M = N * N;

int n, m, Q;
struct Edge {
    int a, b;
} e[M];
int p[N];

int find(int x) {
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

int main() {
    scanf("%d%d%d", &n, &m, &Q);
    for (int i = 0; i < m; ++i) scanf("%d%d", &e[i].a, &e[i].b);

    while (Q--) {
        int x;
        scanf("%d", &x);

        for (int i = 1; i <= n; ++i) p[i] = i;

        int cnt = n - 1;        // 剔除1个被占领的
        for (int i = 0; i < m; ++i) {
            int a = e[i].a, b = e[i].b;
            if (a != x && b != x) {
                int pa = find(a), pb = find(b);
                if (pa != pb) {
                    p[pa] = pb;
                    cnt--;
                }
            }
        }
        printf("%d\n", cnt - 1);
    }

    return 0;
}
