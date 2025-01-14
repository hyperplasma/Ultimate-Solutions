#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 1010;

int n;
vector<int> hobby[N];
int p[N], cnt[N];

int find(int x) {
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        int k;
        scanf("%d:", &k);
        while (k--) {
            int h;
            scanf("%d", &h);
            hobby[h].push_back(i);
        }
    }

    for (int i = 1; i <= n; ++i) p[i] = i;

    for (int i = 1; i < N; ++i)
        for (int j = 1; j < hobby[i].size(); ++j) {
            int a = hobby[i][0], b = hobby[i][j];
            p[find(a)] = find(b);
        }

    for (int i = 1; i <= n; ++i) cnt[find(i)]++;    // !!!

    sort(cnt + 1, cnt + n + 1, greater<int>());

    int k = 1;
    while (cnt[k]) k++;

    cout << k - 1 << endl;
    for (int i = 1; i < k; ++i) {
        if (i > 1) cout << " ";
        cout << cnt[i];
    }

    return 0;
}
