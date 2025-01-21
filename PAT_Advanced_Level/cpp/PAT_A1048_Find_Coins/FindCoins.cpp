#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

const int N = 10010, INF = 0x3f3f3f3f;

int n, m;
unordered_set<int> st;

int main() {
    cin >> n >> m;

    int v1 = INF, v2;
    for (int i = 0; i < n; ++i) {
        int x;
        cin >> x;
        int y = m - x;        // should x + y = m
        if (st.count(y)) {
            st.insert(x);
            if (x > y) swap(x, y);
            if (x < v1) v1 = x, v2 = y;
        } else st.insert(x);
    }

    if (v1 == INF) cout << "No Solution" << endl;
    else cout << v1 << " " << v2 << endl;

    return 0;
}
