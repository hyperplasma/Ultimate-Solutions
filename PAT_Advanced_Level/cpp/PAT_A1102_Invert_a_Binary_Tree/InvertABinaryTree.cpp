#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 20;

int n;
int l[N], r[N];
bool has_fa[N], is_first = true;

void invert(int u) {
    if (u != -1) {
        invert(l[u]);
        invert(r[u]);
        swap(l[u], r[u]);
    }
}

void bfs(int u) {
    int q[N], front = 0, rear = 0;
    q[rear++] = u;

    while (front != rear) {
        int t = q[front++];
        if (l[t] != -1) q[rear++] = l[t];
        if (r[t] != -1) q[rear++] = r[t];
    }

    for (int i = 0; i < rear; ++i) {
        if (i > 0) cout << " ";
        cout << q[i];
    }
    cout << endl;
}

void dfs(int u) {
    if (u != -1) {
        dfs(l[u]);

        if (is_first) is_first = false;
        else cout << " ";
        cout << u;

        dfs(r[u]);
    }
}

int main() {
    memset(l, -1, sizeof(l));
    memset(r, -1, sizeof(r));

    cin >> n;
    for (int i = 0; i < n; ++i) {
        string lchild, rchild;
        cin >> lchild >> rchild;

        if (lchild == "-") l[i] = -1;
        else {
            int son = stoi(lchild);
            l[i] = son;
            has_fa[son] = true;
        }

        if (rchild == "-") r[i] = -1;
        else {
            int son = stoi(rchild);
            r[i] = son;
            has_fa[son] = true;
        }
    }

    int root = 0;
    while (has_fa[root]) root++;

    invert(root);
    bfs(root);
    dfs(root);

    return 0;
}
