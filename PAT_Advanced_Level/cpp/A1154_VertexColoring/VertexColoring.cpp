#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

const int N = 10010;

int n, m;
struct Edge {
    int a, b;
} e[N];
int color[N];

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; ++i) scanf("%d%d", &e[i].a, &e[i].b);

    int k;
    scanf("%d", &k);
    while (k--) {
        unordered_set<int> st;
        for (int i = 0; i < n; ++i) {
            scanf("%d", &color[i]);
            st.insert(color[i]);
        }

        bool flag = true;
        for (int i = 0; i < m; ++i)
            if (color[e[i].a] == color[e[i].b]) {
                flag = false;
                break;
            }

        if (!flag) printf("No\n");
        else printf("%d-coloring\n", st.size());
    }

    return 0;
}
