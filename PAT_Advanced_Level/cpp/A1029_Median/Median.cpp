#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 200010;

int n, m;
int a[N], b[N], c[N * 2];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    scanf("%d", &m);
    for (int i = 0; i < m; ++i) scanf("%d", &b[i]);

    int i = 0, j = 0, k = 0;
    while (i < n && j < m) {
        if (a[i] <= b[j]) c[k++] = a[i++];
        else c[k++] = b[j++];
    }
    while (i < n) c[k++] = a[i++];
    while (j < m) c[k++] = b[j++];

    if (k % 2 == 1) printf("%d\n", c[k / 2]);
    else printf("%d\n", c[k / 2 - 1]);

    return 0;
}
