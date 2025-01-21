#include <iostream>
#include <cstring>
#include <vector>

using namespace std;

const int N = 100010, M = N * 2;

int n;
int h[N], e[M], ne[M], idx;
int p[N];

int find(int x) {
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

int dfs(int u, int father) {
    int depth = 0;
    for (int i = h[u]; ~i; i = ne[i]) {
        int j = e[i];
        if (j == father) continue;
        depth = max(depth, dfs(j, u) + 1);
    }
    return depth;
}

int main() {
    memset(h, -1, sizeof(h));

    cin >> n;
    for (int i = 1; i <= n; ++i) p[i] = i;

    int k = n;
    for (int i = 1; i < n; ++i) {
        int a, b;
        cin >> a >> b;
        if (find(a) != find(b)) {
            k--;
            p[find(a)] = find(b);
        }
        add(a, b), add(b, a);
    }

    if (k > 1) printf("Error: %d components\n", k);
    else {
        vector<int> nodes;
        int max_depth = -1;

        for (int i = 1; i <= n; ++i) {
            int depth = dfs(i, -1);
            if (depth > max_depth) {
                max_depth = depth;
                nodes.clear();
                nodes.push_back(i);
            } else if (depth == max_depth) nodes.push_back(i);
        }

        for (auto node: nodes)
            cout << node << endl;
    }
    return 0;
}
