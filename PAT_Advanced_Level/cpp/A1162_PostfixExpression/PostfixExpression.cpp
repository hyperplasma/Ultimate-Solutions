#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 30;

int n;
int l[N], r[N];
string w[N], res;
bool has_fa[N];

void dfs(int u) {
    if (u != -1) {
        res += "(";
        bool is_sign = (l[u] == -1 && r[u] != -1);
        dfs(l[u]);
        if (is_sign) res += w[u];

        dfs(r[u]);
        if (!is_sign) res += w[u];
        res += ")";
    }
}

int main() {
    memset(l, -1, sizeof(l));
    memset(r, -1, sizeof(r));

    cin >> n;
    for (int i = 1; i <= n; ++i) {
        string data;
        int lchild, rchild;
        cin >> data >> lchild >> rchild;

        w[i] = data;
        if (lchild != -1) {
            l[i] = lchild;
            has_fa[lchild] = true;
        }
        if (rchild != -1) {
            r[i] = rchild;
            has_fa[rchild] = true;
        }
    }

    int root = 1;
    while (has_fa[root]) root++;

    dfs(root);
    cout << res << endl;

    return 0;
}
