#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <unordered_set>

using namespace std;

const int N = 110;

int n;
int p[N];
unordered_set<int> st;

void check(int w1, int w2) {
    for (int i = 1; i <= n; ++i) {
        int q = abs(p[i]);
        bool is_w = (p[i] < 0);

        if (q != w1 && q != w2 && is_w) st.insert(i);
        else if ((q == w1 || q == w2) && !is_w) st.insert(i);
    }
}

int main() {
    cin >> n;
    for (int i = 1; i <= n; ++i) cin >> p[i];

    for (int i = 1; i <= n; ++i)
        for (int j = i; j <= n; ++j)
            if (i != j) {
                st.clear();
                check(i, j);

                if (st.size() != 2) continue;

                int cnt = 0;
                for (auto lier: st)
                    if (lier == i || lier == j) cnt++;
                if (cnt != 1) continue;

                cout << i << " " << j << endl;
                return 0;
            }

    cout << "No Solution" << endl;
    return 0;
}
