#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 10010;

int n, row, col;    // row >= col
int a[N], g[N][N];
int d[][4] = {
        {0, 1, 0,  -1},
        {1, 0, -1, 0},
};

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);

    sort(a, a + n, greater<int>());

    for (int i = 1; i <= n / i; ++i)
        if (n % i == 0) {
            row = n / i;
            col = i;
        }

    int cnt = 0, k = 0;
    int x = 0, y = 0;
    while (cnt < n) {
        g[x][y] = a[cnt++];

        int nx = x + d[0][k], ny = y + d[1][k];
        if (g[nx][ny] || nx < 0 || nx >= row || ny < 0 || ny >= col) {
            k = (k + 1) % 4;
            nx = x + d[0][k], ny = y + d[1][k];
        }
        x = nx;
        y = ny;
    }

    for (int i = 0; i < row; ++i) {
        for (int j = 0; j < col; ++j) {
            if (j > 0) printf(" ");
            printf("%d", g[i][j]);
        }
        printf("\n");
    }

    return 0;
}
