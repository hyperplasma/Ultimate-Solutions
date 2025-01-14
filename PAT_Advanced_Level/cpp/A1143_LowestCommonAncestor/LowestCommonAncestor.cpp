#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>

using namespace std;

const int N = 10010;

int n, Q;
int p[N], depth[N];    // BST: 左<，右>=
unordered_map<int, int> pos;    // pos：原值->离散值
int w[N], pre[N], in[N];        // w[]：离散值->原值

int build(int inL, int inR, int preL, int preR, int d) {
    int root = pre[preL];
    depth[root] = d;

    int k = root;
    if (inL < k) p[build(inL, k - 1, preL + 1, preL + 1 + (k - 1 - inL), d + 1)] = root;
    if (k < inR) p[build(k + 1, inR, preL + 1 + (k - 1 - inL) + 1, preR, d + 1)] = root;

    return root;
}

int main() {
    scanf("%d%d", &Q, &n);

    for (int i = 0; i < n; ++i) {
        scanf("%d", &pre[i]);
        w[i] = pre[i];    // 由先序序列，读入原值存于w[]
    }
    sort(w, w + n);    // 离散化：将原值离散化为[0, n - 1]
    for (int i = 0; i < n; ++i) {
        pos[w[i]] = i;    // 因为是BST，故离散值同时可用作查找子树根的中序位置
        in[i] = i;
    }
    for (int i = 0; i < n; ++i) pre[i] = pos[pre[i]];    // 最后将先序序列离散化

    build(0, n - 1, 0, n - 1, 0);

    while (Q--) {
        int a, b;
        scanf("%d%d", &a, &b);

        if (!pos.count(a) && !pos.count(b)) printf("ERROR: %d and %d are not found.\n", a, b);
        else if (!pos.count(a)) printf("ERROR: %d is not found.\n", a);
        else if (!pos.count(b)) printf("ERROR: %d is not found.\n", b);
        if (!pos.count(a) || !pos.count(b)) continue;

        a = pos[a];
        b = pos[b];
        int a0 = a, b0 = b;
        while (a != b) {
            if (depth[a] > depth[b]) a = p[a];
            else b = p[b];
        }

        if (b == a0) printf("%d is an ancestor of %d.\n", w[a0], w[b0]);
        else if (a == b0) printf("%d is an ancestor of %d.\n", w[b0], w[a0]);
        else printf("LCA of %d and %d is %d.\n", w[a0], w[b0], w[a]);
    }

    return 0;
}
