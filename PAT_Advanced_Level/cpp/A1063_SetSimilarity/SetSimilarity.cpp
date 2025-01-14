#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

const int N = 60;

int n, Q;
unordered_set<int> s[N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        int m;
        scanf("%d", &m);
        while (m--) {
            int x;
            scanf("%d", &x);
            s[i].insert(x);
        }
    }

    scanf("%d", &Q);
    while (Q--) {
        int a, b;
        scanf("%d%d", &a, &b);

        int cnt = 0;
        unordered_set<int> st = s[b];
        for (auto it: s[a]) {
            st.insert(it);
            if (s[b].count(it)) cnt++;
        }

        printf("%.1f%%\n", cnt * 100.0 / st.size());
    }

    return 0;
}
