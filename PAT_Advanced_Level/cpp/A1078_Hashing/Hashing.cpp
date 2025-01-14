#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010;

int msize, n;
int Hash[N], pos[N];

bool is_prime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= n / i; ++i)
        if (n % i == 0) return false;
    return true;
}

int main() {
    scanf("%d%d", &msize, &n);
    while (!is_prime(msize)) msize++;

    for (int i = 0; i < n; ++i) {
        int x;
        scanf("%d", &x);

        int t = x % msize, step = 0;
        bool success = false;
        while (step <= msize) {
            int ad = (t + step * step) % msize;
            if (!Hash[ad]) {
                Hash[ad] = x;
                pos[i] = ad;
                success = true;
                break;
            }
            step++;
        }

        if (!success) pos[i] = -1;
    }

    for (int i = 0; i < n; ++i) {
        if (i > 0) printf(" ");

        if (pos[i] == -1) printf("-");
        else printf("%d", pos[i]);
    }

    return 0;
}
