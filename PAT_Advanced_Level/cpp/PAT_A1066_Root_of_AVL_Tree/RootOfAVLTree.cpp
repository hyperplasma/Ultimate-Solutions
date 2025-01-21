#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 30;

int n;
int l[N], r[N], w[N], h[N], idx;

void update(int u) {
    h[u] = max(h[l[u]], h[r[u]]) + 1;
}

int getBF(int u) {
    return h[l[u]] - h[r[u]];
}

void L(int &u) {
    int p = r[u];
    r[u] = l[p], l[p] = u;
    update(u), update(p);
    u = p;
}

void R(int &u) {
    int p = l[u];
    l[u] = r[p], r[p] = u;
    update(u), update(p);
    u = p;
}

void insert(int &u, int x) {
    if (!u) {
        u = ++idx;
        w[u] = x;
    } else if (x < w[u]) {
        insert(l[u], x);
        if (getBF(u) == 2) {
            if (getBF(l[u]) == 1) R(u);
            else if (getBF(l[u]) == -1) L(l[u]), R(u);
        }
    } else {
        insert(r[u], x);
        if (getBF(u) == -2) {
            if (getBF(r[u]) == -1) L(u);
            else if (getBF(r[u]) == 1) R(r[u]), L(u);
        }
    }

    update(u);
}

int main() {
    scanf("%d", &n);

    int root = 0;
    for (int i = 0; i < n; ++i) {
        int x;
        scanf("%d", &x);
        insert(root, x);
    }

    printf("%d\n", w[root]);
    return 0;
}
