#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

typedef long long LL;

int n, k;
LL m;

LL gcd(LL a, LL b) {
    return !b ? a : gcd(b, a % b);
}

LL getSum(LL a) {
    LL sum = 0;
    while (a) {
        sum += a % 10;
        a /= 10;
    }
    return sum;
}

bool isPrime(LL a) {
    if (a <= 1) return false;

    LL sqrt_a = sqrt(1.0 * a);
    for (LL i = 2; i <= sqrt_a; i++)
        if (a % sqrt_a == 0)
            return false;
    return true;
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d %lld", &k, &m);
        printf("Case %d\n", i + 1);

        bool flag = false;
        vector <pair<LL, LL>> v;
        for (int a = 99 + pow(10, k - 1); a < pow(10, k); a += 100) {
            if (m == getSum(a)) {
                LL res = getSum(a + 1);
                LL d = gcd(m, res);
                if (d > 2 && isPrime(d)) {
                    v.push_back(make_pair(res, a));
                    flag = true;
                }
            }
        }

        if (!flag) puts("No Solution");
        else {
            sort(v.begin(), v.end());
            for (int i = 0; i < v.size(); i++)
                printf("%lld %lld\n", v[i].first, v[i].second);
        }
    }
    return 0;
}
