#include <iostream>
#include <cstring>
#include <queue>
#include <unordered_map>

using namespace std;

const int N = 30;

int n, m, k, Q;
int sum[N];
queue<int> q[N];
unordered_map<int, int> Hash;

int main() {
    cin >> n >> m >> k >> Q;

    for (int i = 1; i <= k; ++i) {
        int s;
        cin >> s;

        int t = 0;
        for (int j = 0; j < n; ++j) {
            if (i <= n * m) {
                if (q[j].size() < q[t].size()) t = j;
            } else if (q[j].front() < q[t].front()) t = j;
        }

        sum[t] += s;
        if (i > n * m) q[t].pop();
        q[t].push(sum[t]);

        if (sum[t] - s < 9 * 60) Hash[i] = sum[t];
    }

    while (Q--) {
        int id;
        cin >> id;
        if (Hash[id]) printf("%02d:%02d\n", Hash[id] / 60 + 8, Hash[id] % 60);
        else printf("Sorry\n");
    }

    return 0;
}
