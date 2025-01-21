#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 100010, INF = 0x3f3f3f3f;

int n;
double P, R;
vector<int> tr[N];
bool has_son[N];
int depth[N];

void DFS(int u, int d) {
    if (!has_son[u]) {
        depth[u] = d;
        return;
    }

    for (auto v: tr[u])
        DFS(v, d + 1);
}

int main() {
    scanf("%d%lf%lf", &n, &P, &R);
    R *= 0.01;

    int root;
    for (int i = 0; i < n; ++i) {
        int fa;
        scanf("%d", &fa);

        if (fa == -1) root = i;
        else {
            tr[fa].push_back(i);
            has_son[fa] = true;
        }
    }

    DFS(root, 0);

    double maxp = -INF;
    int cnt = 0;
    for (int i = 0; i < n; ++i)
        if (!has_son[i]) {
            double p = P * pow(1 + R, depth[i]);
            if (p > maxp) {
                maxp = p;
                cnt = 1;
            } else if (p == maxp) cnt++;
        }

    printf("%.2f %d", maxp, cnt);

    return 0;
}
