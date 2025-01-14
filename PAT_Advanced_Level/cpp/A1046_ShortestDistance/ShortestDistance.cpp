#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010;

int n, m;
int s[N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &s[i]);
        s[i] += s[i - 1];
    }

    scanf("%d", &m);
    while (m--) {
        int a, b;
        scanf("%d%d", &a, &b);

        int l1 = abs(s[a - 1] - s[b - 1]);
        int l2 = abs(s[n] - l1);

        printf("%d\n", min(l1, l2));
    }

    return 0;
}
