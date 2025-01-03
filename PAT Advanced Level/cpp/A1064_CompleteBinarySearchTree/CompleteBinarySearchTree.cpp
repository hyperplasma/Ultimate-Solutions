#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1010;

int n;
int tr[N];            // BST: 左< 右>=
int in[N], num = 0;

void dfs(int u) {
    if (u <= n) {
        dfs(2 * u);
        tr[u] = in[num++];
        dfs(2 * u + 1);
    }
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) scanf("%d", &in[i]);

    sort(in, in + n);
    dfs(1);

    for (int i = 1; i <= n; i++) {
        if (i > 1) printf(" ");
        printf("%d", tr[i]);
    }
    printf("\n");

    return 0;
}
