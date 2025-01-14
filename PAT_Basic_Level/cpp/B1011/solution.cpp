#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int n;
long long a, b, c;

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) {
        scanf("%lld%lld%lld", &a, &b, &c);
        if (a + b > c) printf("Case #%d: true\n", i);
        else printf("Case #%d: false\n", i);
    }

    return 0;
}
