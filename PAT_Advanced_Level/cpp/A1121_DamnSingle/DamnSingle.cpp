#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <unordered_set>

using namespace std;

const int N = 50010, M = 10010;

int n, m;
unordered_set<int> st;

struct Couple {
    int a, b;
} c[N];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d%d", &c[i].a, &c[i].b);

    scanf("%d", &m);
    for (int i = 0; i < m; ++i) {
        int x;
        scanf("%d", &x);
        st.insert(x);
    }

    for (int i = 0; i < n; ++i)
        if (st.count(c[i].a) && st.count(c[i].b)) {
            st.erase(c[i].a);
            st.erase(c[i].b);
        }

    vector<int> res;
    for (auto it: st) res.push_back(it);
    sort(res.begin(), res.end());

    printf("%d\n", res.size());
    for (int i = 0; i < res.size(); ++i) {
        if (i > 0) printf(" ");
        printf("%05d", res[i]);
    }

    return 0;
}
