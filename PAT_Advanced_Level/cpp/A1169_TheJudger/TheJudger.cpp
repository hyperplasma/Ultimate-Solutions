#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <unordered_set>

using namespace std;

const int N = 10010;

int n, m;        // [1, n]
int p[N][N];    // p[人][轮]
bool is_out[N];
unordered_set<int> st;

bool check(int x) {
    if (st.count(x)) return false;
    for (auto it: st)
        if (st.count(x + it)) return true;

    return false;
}

int main() {
    int t1, t2;
    scanf("%d%d", &t1, &t2);
    st.insert(t1);
    st.insert(t2);

    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i)
        for (int j = 1; j <= m; ++j)
            scanf("%d", &p[i][j]);

    for (int j = 1; j <= m; ++j) {
        vector<int> out;

        for (int i = 1; i <= n; ++i)
            if (!is_out[i]) {
                int x = p[i][j];
                if (check(x)) st.insert(x);
                else {
                    is_out[i] = true;
                    out.push_back(i);
                }
            }

        if (!out.empty()) {
            sort(out.begin(), out.end());
            for (auto i: out)
                printf("Round #%d: %d is out.\n", j, i);
        }
    }

    vector<int> win;
    for (int i = 1; i <= n; ++i)
        if (!is_out[i]) win.push_back(i);

    if (win.empty()) printf("No winner.\n");
    else {
        sort(win.begin(), win.end());

        printf("Winner(s):");
        for (auto i: win)
            printf(" %d", i);
        printf("\n");
    }
    return 0;
}
