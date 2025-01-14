#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

const int N = 100010;

int n, m;
int danger1[N], danger2[N];
unordered_set<int> st;

int main() {
    scanf("%d%d", &n, &m);

    for (int i = 0; i < n; ++i)
        scanf("%d%d", &danger1[i], &danger2[i]);

    while (m--) {
        int k;
        scanf("%d", &k);

        st.clear();
        while (k--) {
            int x;
            scanf("%d", &x);
            st.insert(x);
        }

        bool flag = true;
        for (int i = 0; i < n; ++i)
            if (st.count(danger1[i]) && st.count(danger2[i])) {
                flag = false;
                break;
            }

        if (flag) printf("Yes\n");
        else printf("No\n");
    }

    return 0;
}
