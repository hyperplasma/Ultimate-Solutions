#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 10010;

int TSize, n, m;
int Hash[N];

bool is_prime(int n) {
    if (n <= 1) return false;

    for (int i = 2; i <= n / i; ++i)
        if (n % i == 0) return false;

    return true;
}

int main() {
    scanf("%d%d%d", &TSize, &n, &m);
    while (!is_prime(TSize)) TSize++;

    for (int i = 0; i < n; ++i) {
        int x;
        scanf("%d", &x);

        int step = 0;
        while (step <= TSize) {
            int ad = (x + step * step) % TSize;

            if (!Hash[ad]) {
                Hash[ad] = x;
                break;
            }
            step++;
        }

        if (step > TSize) printf("%d cannot be inserted.\n", x);
    }

    double sum = 0;
    for (int i = 0; i < m; ++i) {
        int x;
        scanf("%d", &x);

        bool flag = false;
        int step = 0;
        while (step <= TSize) {
            int ad = (x + step * step) % TSize;
            if (!Hash[ad] || Hash[ad] == x) {
                flag = true;
                sum += step + 1;
                break;
            }
            step++;
        }

        if (!flag) sum += step;
    }

    printf("%.1f\n", sum / m);

    return 0;
};
