#include <iostream>
#include <cstring>
#include <algorithm>
#include <set>
#include <unordered_set>

using namespace std;

const int N = 110;

int k;
bool is_covered[N];
set<int, greater<int> > keys;
unordered_set<int> st;

int main() {
    scanf("%d", &k);
    for (int i = 0; i < k; i++) {
        int n;
        scanf("%d", &n);
        st.insert(n);
    }

    for (auto n: st)
        while (n != 1) {
            if (n % 2 == 0) {
                is_covered[n / 2] = true;
                n /= 2;
            } else {
                if ((3 * n + 1) / 2 < N) is_covered[(3 * n + 1) / 2] = true;
                n = (3 * n + 1) / 2;
            }
        }

    for (int i = 1; i < N; i++)
        if (st.count(i) && !is_covered[i]) keys.insert(i);

    for (auto key: keys) {
        if (key != *keys.begin()) printf(" ");
        printf("%d", key);
    }

    return 0;
}
