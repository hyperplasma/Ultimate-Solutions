#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

const int N = 210;

int n, m;
bool g[N][N], tag[N];        // [1, n]
int seq[N];
unordered_set<int> st;

int main() {
    scanf("%d%d", &n, &m);

    for (int i = 0; i < m; ++i) {
        int a, b;
        scanf("%d%d", &a, &b);
        g[a][b] = g[b][a] = true;
        tag[a] = tag[b] = true;
    }

    int Q;
    scanf("%d", &Q);
    for (int k = 1; k <= Q; ++k) {
        st.clear();

        int num;
        scanf("%d", &num);
        for (int i = 0; i < num; ++i) {
            scanf("%d", &seq[i]);
            st.insert(seq[i]);
        }

        bool flag = true;
        for (int i = 0; i < num; ++i)
            for (int j = i; j < num; ++j)
                if (i != j && !g[seq[i]][seq[j]]) {
                    flag = false;
                    break;
                }
        if (!flag) {
            printf("Area %d needs help.\n", k);
            continue;
        }

        for (int i = 1; i <= n; ++i)
            if (tag[i] && !st.count(i)) {
                bool is_valid = true;
                for (int j = 0; j < num; ++j)
                    if (!g[i][seq[j]]) {
                        is_valid = false;
                        break;
                    }
                if (is_valid) {
                    printf("Area %d may invite more people, such as %d.\n", k, i);
                    flag = false;
                    break;
                }
            }

        if (flag) printf("Area %d is OK.\n", k);
    }

    return 0;
}
