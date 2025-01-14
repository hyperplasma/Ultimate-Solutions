#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 100010;

int n;
double P, R;
vector<int> tr[N];            // root = 0
int retail[N], depth[N];

void dfs(int u, int d) {
    if (retail[u]) {
        depth[u] = d;
        return;
    }

    for (auto v: tr[u])
        dfs(v, d + 1);
}

int main() {
    scanf("%d%lf%lf", &n, &P, &R);
    R *= 0.01;        // !

    for (int i = 0; i < n; ++i) {
        int k;
        scanf("%d", &k);

        if (!k) scanf("%d", &retail[i]);

        while (k--) {
            int son;
            scanf("%d", &son);
            tr[i].push_back(son);
        }
    }

    dfs(0, 0);

    double sum = 0;
    for (int i = 0; i < n; ++i)
        if (retail[i])
            sum += retail[i] * P * pow(1 + R, depth[i]);
    printf("%.1f\n", sum);

    return 0;
}
