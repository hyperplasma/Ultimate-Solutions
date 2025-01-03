#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>

using namespace std;

const int N = 30;

int n;
int l[N], r[N], v[N], h[N], idx;
int level[N], pos[N];
bool flag = true;

void update(int u) {
    h[u] = max(h[l[u]], h[r[u]]) + 1;
}

int BF(int u) {
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

void insert(int &u, int w) {
    if (!u) {
        u = ++idx;
        v[u] = w;
    } else if (w < v[u]) {
        insert(l[u], w);
        if (BF(u) == 2) {
            if (BF(l[u]) == 1) R(u);
            else L(l[u]), R(u);
        }
    } else {
        insert(r[u], w);
        if (BF(u) == -2) {
            if (BF(r[u]) == -1) L(u);
            else R(r[u]), L(u);
        }
    }

    update(u);
}

void bfs(int u) {
    queue<int> q;
    q.push(u);
    pos[u] = 1;
    bool is_first = true;

    while (!q.empty()) {
        int t = q.front();
        q.pop();

        if (is_first) is_first = false;
        else printf(" ");
        printf("%d", v[t]);

        if (pos[t] > n) flag = false;

        if (l[t]) {
            q.push(l[t]);
            pos[l[t]] = 2 * pos[t];
        }
        if (r[t]) {
            q.push(r[t]);
            pos[r[t]] = 2 * pos[t] + 1;
        }
    }

    printf("\n");
}

int main() {
    scanf("%d", &n);

    int root = 0;
    for (int i = 0; i < n; ++i) {
        int x;
        scanf("%d", &x);
        insert(root, x);
    }

    bfs(root);

    if (flag) printf("YES\n");
    else printf("NO\n");

    return 0;
};
