#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long LL;

bool is_prime(int n) {
    if (n == 1) return false;
    for (int i = 2; i * i <= n; i++)
        if (n % i == 0) return false;
    return true;
}

bool check(int n, int d) {
    if (!is_prime(n)) return false;

    LL r = 0;
    while (n) {
        r = r * d + n % d;
        n /= d;
    }

    return is_prime(r);
}

int main() {
    int n, d;
    while (cin >> n >> d, n >= 1) {
        if (check(n, d)) puts("Yes");
        else puts("No");
    }

    return 0;
}
