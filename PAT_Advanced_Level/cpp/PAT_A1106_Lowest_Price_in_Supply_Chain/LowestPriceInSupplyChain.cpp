#include <iostream>
#include <cstring>
#include <algorithm>
#include <cmath>
#include <vector>

using namespace std;

const int N = 100010, INF = 0x3f3f3f3f;

int n;                // [0, n - 1]
double P, R;
vector<int> tr[N];
bool is_retailer[N], st[N];
int depth[N];

void dfs(int u, int d) {
    depth[u] = d;

    for (auto i: tr[u])
        dfs(i, d + 1);
}

int main() {
    scanf("%d%lf%lf", &n, &P, &R);
    for (int i = 0; i < n; ++i) {
        int k;
        scanf("%d", &k);

        if (!k) is_retailer[i] = true;

        while (k--) {
            int son;
            scanf("%d", &son);
            tr[i].push_back(son);
            st[son] = true;
        }
    }

    int root = 0;
    for (int i = 0; i < n; ++i)
        if (!st[i]) {
            root = i;
            break;
        }

    dfs(root, 0);

    int cnt = 0, minp = INF;
    for (int i = 0; i < n; ++i)
        if (is_retailer[i] && depth[i] < minp) {
            minp = depth[i];
            cnt = 1;
        } else if (is_retailer[i] && depth[i] == minp) cnt++;

    printf("%.4f %d\n", P * pow(1 + 0.01 * R, minp), cnt);

    return 0;
}
