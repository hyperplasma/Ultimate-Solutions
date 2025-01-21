#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long ll;

ll gcd(ll a, ll b) {
    return b ? gcd(b, a % b) : a;
}

void print(ll a, ll b) {
    ll d = gcd(a, b);
    a /= d, b /= d;

    if (b < 0) a *= -1, b *= -1;
    bool is_minus = (a < 0);

    if (is_minus) printf("(");

    if (b == 1) printf("%lld", a);    // 可整除
    else {
        if (llabs(a) >= b) printf("%lld ", a / b), a = llabs(a) % b;    // 假分数
        printf("%lld/%lld", a, b);    // 真分数
    }

    if (is_minus) printf(")");
}

int main() {
    ll a, b, c, d;
    scanf("%lld/%lld %lld/%lld", &a, &b, &c, &d);

    print(a, b), printf(" + "), print(c, d), printf(" = "), print(a * d + c * b, b * d), printf("\n");
    print(a, b), printf(" - "), print(c, d), printf(" = "), print(a * d - c * b, b * d), printf("\n");
    print(a, b), printf(" * "), print(c, d), printf(" = "), print(a * c, b * d), printf("\n");
    print(a, b), printf(" / "), print(c, d), printf(" = ");
    if (c == 0) printf("Inf\n");
    else print(a * d, b * c), printf("\n");

    return 0;
}
