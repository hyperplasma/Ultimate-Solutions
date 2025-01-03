#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 110;

int n, m;
int a[N];

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; i++) scanf("%d", &a[i]);

    if (n == 1 || (n == 2 && m == 2)) {
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) printf(" ");
            printf("%d", a[i]);
        }
    } else {
        reverse(a, a + n - m % n);
        reverse(a + n - m % n, a + n);
        reverse(a, a + n);
        for (int i = 0; i < n; i++) {
            if (i > 0) printf(" ");
            printf("%d", a[i]);
        }
    }

    return 0;
}
