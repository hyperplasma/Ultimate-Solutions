#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

// maxheap: ≤, minheap: ≥

const int N = 1010;

int n;
int tr[N];
vector<int> path;
bool is_greater, is_less;

void dfs(int u) {
    path.push_back(tr[u]);
    if (2 * u > n) {
        for (int i = 0; i < path.size(); ++i) {
            if (i > 0) printf(" ");
            printf("%d", path[i]);
        }
        printf("\n");
    }

    if (2 * u + 1 <= n) {
        if (tr[2 * u + 1] < tr[u]) is_greater = true;
        else is_less = true;
        dfs(2 * u + 1);
    }

    if (2 * u <= n) {
        if (tr[2 * u] < tr[u]) is_greater = true;
        else is_less = true;
        dfs(2 * u);
    }

    path.pop_back();
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &tr[i]);

    dfs(1);

    if (is_greater && !is_less) printf("Max Heap\n");
    else if (!is_greater && is_less) printf("Min Heap\n");
    else printf("Not Heap");

    return 0;
}
