#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 10010;

int n;
int a[N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);

    int l = 1, r = 1, width = r - l;
    int this_sum = -1, max_sum = -1;

    for (int i = 1, start = 1; i <= n; ++i) {
        if (this_sum < 0) {
            this_sum = 0;
            start = i;
        }

        this_sum += a[i];
        if (this_sum > max_sum) {
            max_sum = this_sum;
            l = start, r = i;
        }
    }

    if (max_sum < 0) printf("0 %d %d\n", a[1], a[n]);
    else printf("%d %d %d\n", max_sum, a[l], a[r]);

    return 0;
}
