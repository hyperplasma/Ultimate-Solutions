#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

const int N = 210;

int n, m;
bool g[N][N];    // [1, n]
int seq[N];
unordered_set<int> st;

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; ++i) {
        int a, b;
        scanf("%d%d", &a, &b);
        g[a][b] = g[b][a] = true;
    }

    int Q;
    scanf("%d", &Q);
    while (Q--) {
        st.clear();

        int k;
        scanf("%d", &k);
        for (int i = 0; i < k; ++i) {
            scanf("%d", &seq[i]);
            st.insert(seq[i]);
        }

        int flag = 2;
        for (int i = 0; i < k; ++i)
            for (int j = i; j < k; ++j)
                if (i != j && !g[seq[i]][seq[j]]) {
                    flag = 0;
                    break;
                }

        if (flag) {
            for (int v = 1; v <= n; ++v)
                if (!st.count(v)) {
                    bool is_adj = true;
                    for (int i = 0; i < k; ++i)
                        if (!g[v][seq[i]]) {
                            is_adj = false;
                            break;
                        }

                    if (is_adj) {
                        flag = 1;
                        break;
                    }
                }
        }

        if (flag == 2) printf("Yes\n");
        else if (flag == 1) printf("Not Maximal\n");
        else printf("Not a Clique\n");
    }

    return 0;
}
