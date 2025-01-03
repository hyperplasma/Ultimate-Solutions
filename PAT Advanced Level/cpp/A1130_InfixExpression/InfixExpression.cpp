#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 30;

int n;
int l[N], r[N];
string w[N], res;
bool has_fa[N];

void dfs(int u) {
    if (u != -1) {
        int cnt = 0;
        if (l[u] != -1) cnt++;
        if (r[u] != -1) cnt++;

        if (cnt) res += "(";
        dfs(l[u]);

        res += w[u];

        dfs(r[u]);
        if (cnt) res += ")";
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

    if (res[0] == '(') res = res.substr(1);
    if (res[res.size() - 1] == ')') res.pop_back();
    cout << res << endl;

    return 0;
}
