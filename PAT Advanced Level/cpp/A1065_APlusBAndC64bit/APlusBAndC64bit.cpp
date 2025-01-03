#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long ll;

int n;

int main() {
    scanf("%d", &n);

    for (int i = 1; i <= n; ++i) {
        ll a, b, c;
        scanf("%lld%lld%lld", &a, &b, &c);

        printf("Case #%d: ", i);
        if (a - c + b > 0) printf("true\n");
        else printf("false\n");
    }

    return 0;
}
