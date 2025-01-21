#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

const int N = 1010;

int n, m, k;
int g[N][N];        // [1, n]
vector<int> suspects;
int gang[N], gangNum = 1;

int main() {
    scanf("%d%d%d", &k, &n, &m);

    for (int i = 0; i < m; ++i) {
        int a, b, len;
        scanf("%d%d%d", &a, &b, &len);
        g[a][b] += len;        // 累计通话时间！
    }

    for (int i = 1; i <= n; ++i) {
        int total_cnt = 0, callback_cnt = 0;
        for (int j = 1; j <= n; ++j)
            if (g[i][j] && g[i][j] <= 5) {
                total_cnt++;
                if (g[j][i]) callback_cnt++;
            }
        if (total_cnt > k && callback_cnt <= total_cnt * 0.2)
            suspects.push_back(i);
    }

    if (suspects.empty()) {
        printf("None\n");
        return 0;
    }

    for (auto i: suspects) {
        if (!gang[i]) {
            queue<int> q;
            q.push(i);

            while (!q.empty()) {
                int t = q.front();
                q.pop();

                if (!gang[t]) {
                    gang[t] = gangNum;
                    for (auto j: suspects)
                        if (!gang[j] && g[t][j] && g[j][t])
                            q.push(j);
                }
            }
        }
        gangNum++;
    }

    for (int num = 1; num < gangNum; ++num) {
        vector<int> v;
        for (int i = 0; i < suspects.size(); ++i)
            if (gang[suspects[i]] == num)
                v.push_back(suspects[i]);

        sort(v.begin(), v.end());
        for (int i = 0; i < v.size(); ++i) {
            if (i > 0) printf(" ");
            printf("%d", v[i]);
        }
        if (!v.empty()) printf("\n");
    }

    return 0;
}
