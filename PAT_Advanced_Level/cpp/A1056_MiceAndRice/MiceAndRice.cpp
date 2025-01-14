#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 1010;

int n, m;
int w[N], ans[N];

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> w[i];
    vector<int> cur(n);

    for (int i = 0; i < n; i++) cin >> cur[i];

    while ((int) cur.size() > 1) {
        vector<int> next;
        int remain = (cur.size() + m - 1) / m;    // 每次剩下"n/m"只老鼠 需取模

        for (int i = 0; i < cur.size();) {
            int j = min((int) cur.size(), i + m);

            int t = i;
            for (int k = i; k < j; k++)
                if (w[cur[k]] > w[cur[t]])
                    t = k;
            next.push_back(cur[t]);
            for (int k = i; k < j; k++)
                if (k != t)
                    ans[cur[k]] = remain + 1;

            i = j;
        }

        cur = next;
    }

    ans[cur[0]] = 1;

    cout << ans[0];
    for (int i = 1; i < n; i++) cout << ' ' << ans[i];
    cout << endl;

    return 0;
}
