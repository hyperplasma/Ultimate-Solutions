#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long LL;

LL gcd(LL a, LL b) {
    return !b ? a : gcd(b, a % b);
}

void print(LL a, LL b) {
    int mtag = 1;
    if (a < 0) {
        mtag = -mtag;
        a = -a;
    } else if (a == 0) mtag = 0;

    if (b < 0) {
        mtag = -mtag;
        b = -b;
    }

    LL d = gcd(a, b);
    a = a / d;
    b = b / d;
    LL k = a / b;
    a %= b;

    if (mtag == -1) printf("(-");

    if (k > 0 && a > 0) printf("%lld ", k);
    else if (a == 0) printf("%lld", k);

    if (a > 0) printf("%lld/%lld", a, b);

    if (mtag == -1) printf(")");
}

int main() {
    LL a1, b1, a2, b2;
    scanf("%lld/%lld %lld/%lld", &a1, &b1, &a2, &b2);

    print(a1, b1), printf(" + "), print(a2, b2), printf(" = "), print(a1 * b2 + a2 * b1, b1 * b2), printf("\n");
    print(a1, b1), printf(" - "), print(a2, b2), printf(" = "), print(a1 * b2 - a2 * b1, b1 * b2), printf("\n");
    print(a1, b1), printf(" * "), print(a2, b2), printf(" = "), print(a1 * a2, b1 * b2), printf("\n");
    print(a1, b1), printf(" / "), print(a2, b2), printf(" = ");
    if (a2 == 0) printf("Inf\n");
    else {
        print(a1 * b2, a2 * b1);
        printf("\n");
    }

    return 0;
}
