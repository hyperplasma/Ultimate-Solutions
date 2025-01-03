#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long LL;

const int MAXN = 1e5 + 10;

LL n, p;
LL a[MAXN];

int main() {
    scanf("%lld%lld", &n, &p);
    for (int i = 0; i < n; ++i) scanf("%lld", &a[i]);

    sort(a, a + n);
    int cnt = 1;
    for (int i = 0; i < n; ++i)
        for (int j = i + cnt; j < n; ++j) {
            if (a[j] <= a[i] * p) cnt = j - i + 1;
            else break;
        }

    printf("%d", cnt);

    return 0;
}
