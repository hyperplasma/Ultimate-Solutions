#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

typedef long long ll;

const int N = 100010;

int n;
ll a[N];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%lld", &a[i]);

    sort(a, a + n);

    int i, n1 = 0, n2 = 0;
    ll sum1 = 0, sum2 = 0;
    for (i = 0; i < n / 2; ++i) {
        sum1 += a[i];
        n1++;
    }
    for (; i < n; ++i) {
        sum2 += a[i];
        n2++;
    }

    printf("%d %lld\n", abs(n1 - n2), llabs(sum1 - sum2));

    return 0;
}
