#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

const int N = 100010;

int n, m, k;
struct Edge {
    int a, b;
} e[N];
int r[N];
unordered_set<int> st;

int main() {
    scanf("%d%d%d", &n, &m, &k);
    for (int i = 0; i < m; ++i) scanf("%d%d", &e[i].a, &e[i].b);

    int Q;
    scanf("%d", &Q);
    while (Q--) {
        st.clear();
        for (int i = 1; i <= n; ++i) {
            scanf("%d", &r[i]);
            st.insert(r[i]);
        }

        if (st.size() > k) printf("Error: Too many species.\n");
        else if (st.size() < k) printf("Error: Too few species.\n");
        else {
            bool flag = true;
            for (int i = 0; i < m; ++i)
                if (r[e[i].a] == r[e[i].b]) {
                    flag = false;
                    break;
                }

            if (flag) printf("Yes\n");
            else printf("No\n");
        }
    }

    return 0;
}
