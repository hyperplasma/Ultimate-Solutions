#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>

using namespace std;

const int N = 110;

int n;    // [0, n-1]
int l[N], r[N], w[N];    // 左<, 右>=
int val[N], cnt;
bool st[N];

void dfs(int u) {
    if (u != -1) {
        dfs(l[u]);
        w[u] = val[cnt++];
        dfs(r[u]);
    }
}

void bfs(int u) {
    queue<int> q;
    q.push(u);
    bool is_first = true;

    while (!q.empty()) {
        int t = q.front();
        q.pop();

        if (is_first) is_first = false;
        else cout << " ";
        cout << w[t];

        if (l[t] != -1) q.push(l[t]);
        if (r[t] != -1) q.push(r[t]);
    }
}

int main() {
    cin >> n;

    for (int i = 0; i < n; ++i) {
        int lchild, rchild;
        cin >> lchild >> rchild;

        l[i] = lchild;
        r[i] = rchild;
        st[lchild] = true;
        st[rchild] = true;
    }

    for (int i = 0; i < n; ++i) cin >> val[i];
    sort(val, val + n);

    int root = 0;
    while (st[root]) root++;

    dfs(root);
    bfs(root);

    return 0;
}
