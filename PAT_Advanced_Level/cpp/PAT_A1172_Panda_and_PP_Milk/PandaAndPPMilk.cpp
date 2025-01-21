#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 10010;

int n;
int w[N], m1[N], m2[N];
long long sum;

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &w[i]);

    for (int i = 1; i < n; ++i) {
        if (w[i] > w[i - 1]) m1[i] = m1[i - 1] + 1;
        else if (w[i] == w[i - 1]) m1[i] = m1[i - 1];
        else m1[i] = 0;
    }
    for (int i = n - 2; i >= 0; --i) {
        if (w[i] > w[i + 1]) m2[i] = m2[i + 1] + 1;
        else if (w[i] == w[i + 1]) m2[i] = m2[i + 1];
        else m2[i] = 0;
    }

    sum = 200 * n;
    for (int i = 0; i < n; ++i)
        sum += 100 * max(m1[i], m2[i]);
    printf("%lld\n", sum);

    return 0;
}
