#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long LL;

LL gcd(LL a, LL b) {
    return b ? gcd(b, a % b) : a;
}

int main() {
    LL a = 0, b = 1;

    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        LL c, d;
        scanf("%lld/%lld", &c, &d);

        LL t = gcd(c, d);
        c /= t;
        d /= t;

        t = gcd(b, d);
        a = d / t * a + b / t * c;
        b = b / t * d;

        t = gcd(a, b);
        a /= t;
        b /= t;
    }

    if (b == 1) cout << a;
    else {
        if (a >= b) {
            printf("%lld ", a / b);
            a %= b;
        }
        printf("%lld/%lld", a, b);
    }

    return 0;
}
