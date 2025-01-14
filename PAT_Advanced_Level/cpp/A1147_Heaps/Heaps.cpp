#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1010;

int n, m;
int tr[N];
bool is_greater, is_less, is_first = true;

void check(int u) {
    if (2 * u <= n && tr[u] >= tr[2 * u]) is_greater = true;
    else if (2 * u <= n && tr[u] <= tr[2 * u]) is_less = true;

    if (2 * u + 1 <= n && tr[u] >= tr[2 * u + 1]) is_greater = true;
    else if (2 * u + 1 <= n && tr[u] <= tr[2 * u + 1]) is_less = true;

    if (2 * u <= n) check(2 * u);
    if (2 * u + 1 <= n) check(2 * u + 1);
}

void dfs(int u) {
    if (2 * u <= n) dfs(2 * u);
    if (2 * u + 1 <= n) dfs(2 * u + 1);

    if (is_first) is_first = false;
    else printf(" ");
    printf("%d", tr[u]);
}

int main() {
    scanf("%d%d", &m, &n);

    while (m--) {
        is_greater = false;
        is_less = false;
        is_first = true;

        for (int i = 1; i <= n; ++i) scanf("%d", &tr[i]);

        check(1);

        if (!is_greater && is_less) printf("Min Heap\n");
        else if (is_greater && !is_less) printf("Max Heap\n");
        else printf("Not Heap\n");

        dfs(1);
        printf("\n");
    }
    return 0;
}