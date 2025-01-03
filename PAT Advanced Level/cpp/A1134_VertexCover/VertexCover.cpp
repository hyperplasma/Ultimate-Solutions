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
unordered_set<int> st;

int main() {
    scanf("%d%d", &n, &m);

    for (int i = 0; i < m; ++i) {
        int a, b;
        scanf("%d%d", &a, &b);
        e[i] = {a, b};
    }

    int Q;
    scanf("%d", &Q);
    while (Q--) {
        int num;
        scanf("%d", &num);

        st.clear();
        for (int i = 0; i < num; ++i) {
            int x;
            scanf("%d", &x);
            st.insert(x);
        }

        bool success = true;
        for (int i = 0; i < m; ++i)
            if (!st.count(e[i].a) && !st.count(e[i].b)) {
                success = false;
                break;
            }

        if (success) printf("Yes\n");
        else printf("No\n");
    }

    return 0;
}
