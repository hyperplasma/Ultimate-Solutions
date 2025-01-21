#include <iostream>
#include <cstring>
#include <unordered_map>
#include <algorithm>

using namespace std;

const int N = 10010;

int n, m;
int in[N], pre[N], seq[N];
unordered_map<int, int> pos;
int p[N], depth[N];

int build(int inL, int inR, int preL, int preR, int d) {
    int root = pre[preL];
    int k = root;

    depth[root] = d;

    if (inL < k) p[build(inL, k - 1, preL + 1, preL + 1 + (k - 1 - inL), d + 1)] = root;
    if (k < inR) p[build(k + 1, inR, preL + 1 + (k - 1 - inL) + 1, preR, d + 1)] = root;

    return root;
}

int main() {
    cin >> m >> n;

    for (int i = 0; i < n; ++i) {
        cin >> seq[i];
        pos[seq[i]] = i;
        in[i] = i;
    }

    for (int i = 0; i < n; ++i) {
        cin >> pre[i];
        pre[i] = pos[pre[i]];
    }

    build(0, n - 1, 0, n - 1, 0);

    while (m--) {
        int a, b;
        cin >> a >> b;

        if (pos.count(a) && pos.count(b)) {
            a = pos[a], b = pos[b];
            int a0 = a, b0 = b;

            while (a != b) {
                if (depth[a] > depth[b]) a = p[a];
                else b = p[b];
            }

            if (a != a0 && a != b0) printf("LCA of %d and %d is %d.\n", seq[a0], seq[b0], seq[a]);
            else if (a == a0) printf("%d is an ancestor of %d.\n", seq[a0], seq[b0]);
            else printf("%d is an ancestor of %d.\n", seq[b0], seq[a0]);
        } else if (!pos.count(a) && pos.count(b)) printf("ERROR: %d is not found.\n", a);
        else if (pos.count(a) && !pos.count(b)) printf("ERROR: %d is not found.\n", b);
        else printf("ERROR: %d and %d are not found.\n", a, b);
    }

    return 0;
}
