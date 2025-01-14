#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 30;

int n, k, p;    // k个p次方幂
int v[N];        // i ^ p
vector<int> path, res;
int maxsum = -1;

void dfs(int i, int n, int cnt, int sum) {
    if (n == 0 && cnt == k) {
        if (sum > maxsum) {
            maxsum = sum;
            res = path;
        }
        return;
    }

    for (; i > 0; i--)    // i可一直取
        if (n - v[i] >= 0 && cnt + 1 <= k) {
            path[cnt] = i;
            dfs(i, n - v[i], cnt + 1, sum + i);
        }
}

int main() {
    scanf("%d%d%d", &n, &k, &p);
    path.resize(k);

    int i = 0;
    while (pow(++i, p) <= n) v[i] = pow(i, p);
    i--;

    dfs(i, n, 0, 0);    // 从大到小选

    if (maxsum == -1) printf("Impossible\n");
    else {
        printf("%d =", n);
        for (int i = 0; i < (int) res.size(); ++i) {
            if (i > 0) printf(" +");
            printf(" %d^%d", res[i], p);
        }
        printf("\n");
    }

    return 0;
}
