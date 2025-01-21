#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

const int N = 10010;

int n;
int p[N], bird[N];
unordered_set<int> st;

int find(int x) {
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

void Union(int a, int b) {
    if (a > b) swap(a, b);
    p[find(b)] = find(a);
}

int main() {
    for (int i = 1; i < N; ++i) p[i] = i;

    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        int k;
        scanf("%d", &k);
        for (int j = 0; j < k; ++j) {
            scanf("%d", &bird[j]);
            st.insert(bird[j]);
        }

        for (int j = 0; j < k - 1; ++j)
            Union(bird[j], bird[j + 1]);
    }

    int cnt = 0;
    for (auto i: st)
        if (p[i] == i) cnt++;
    printf("%d %d\n", cnt, st.size());

    int Q;
    scanf("%d", &Q);
    while (Q--) {
        int a, b;
        scanf("%d%d", &a, &b);
        if (p[find(a)] == find(b)) printf("Yes\n");
        else printf("No\n");
    }

    return 0;
}
