#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int MAXN = 110, INF = 0x3f3f3f3f;

int n, m;
int a[MAXN];

int main() {
    scanf("%d %d", &n, &m);
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++) {
            int temp;
            scanf("%d", &temp);
            a[i] = max(a[i], temp);
        }

    int max_a = -INF;
    for (int i = 0; i < n; i++) {
        if (i > 0) printf(" ");
        printf("%d", a[i]);
        max_a = max(max_a, a[i]);
    }
    printf("\n%d", max_a);

    return 0;
}
