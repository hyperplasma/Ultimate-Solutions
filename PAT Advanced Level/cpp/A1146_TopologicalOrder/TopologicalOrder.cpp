#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010;

int n, m;        // ver [1, n]
struct Edge {
    int a, b;
} e[N];
int q[N], pos[N];

int main() {
    scanf("%d%d", &n, &m);

    for (int i = 0; i < m; ++i) {
        int a, b;
        scanf("%d%d", &a, &b);
        e[i] = {a, b};
    }

    int Q;
    scanf("%d", &Q);

    bool is_first = true;
    for (int i = 0; i < Q; ++i) {
        for (int j = 0; j < n; ++j) {
            scanf("%d", &q[j]);
            pos[q[j]] = j;
        }

        for (int j = 0; j < m; ++j) {
            int a = e[j].a, b = e[j].b;
            if (pos[a] >= pos[b]) {
                if (is_first) is_first = false;
                else printf(" ");
                printf("%d", i);
                break;
            }
        }
    }

    return 0;
}
