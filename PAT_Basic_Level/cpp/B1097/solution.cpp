#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 110;

int n, k, x;
int a[N][N];

int main() {
    scanf("%d%d%d", &n, &k, &x);
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
            scanf("%d", &a[i][j]);

    int step = 0;
    for (int i = 1; i <= n; i++) {
        if (i % 2 != 0) {
            step++;
            if (step > k) step = 1;

            for (int j = n; j > step; j--) a[i][j] = a[i][j - step];
            for (int j = step; j > 0; j--) a[i][j] = x;
        }
    }

    for (int j = 1; j <= n; j++) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += a[i][j];

        if (j > 1) printf(" ");
        printf("%d", sum);
    }

    return 0;
}
