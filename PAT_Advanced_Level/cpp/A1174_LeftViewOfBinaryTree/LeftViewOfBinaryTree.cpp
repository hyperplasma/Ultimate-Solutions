#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>
#include <queue>
#include <vector>

using namespace std;

const int N = 10010;

int n;
int l[N], r[N], w[N];
unordered_map<int, int> pos;
int in[N], pre[N];

int build(int inL, int inR, int preL, int preR) {
    int root = pre[preL];

    int k;
    for (k = inL; k <= inR; ++k)
        if (in[k] == root) break;

    if (inL < k) l[root] = build(inL, k - 1, preL + 1, preL + 1 + (k - 1 - inL));
    if (k < inR) r[root] = build(k + 1, inR, preL + 1 + (k - 1 - inL) + 1, preR);

    return root;
}

void bfs(int u) {
    queue<int> q;
    q.push(u);
    vector<int> v;

    while (!q.empty()) {
        int size = q.size();
        v.push_back(q.front());
        while (size--) {
            int t = q.front();
            q.pop();

            if (l[t]) q.push(l[t]);
            if (r[t]) q.push(r[t]);
        }
    }

    for (int i = 0; i < v.size(); ++i) {
        if (i > 0) printf(" ");
        printf("%d", w[v[i]]);
    }
    printf("\n");
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &in[i]);
        w[i] = in[i];
        pos[w[i]] = i;
    }
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &pre[i]);
        pre[i] = pos[pre[i]];
        in[i] = pos[in[i]];
    }

    int root = build(1, n, 1, n);
    bfs(root);

    return 0;
}
