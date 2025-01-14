#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

const int N = 30;

int n;                // [0, n - 1]
int l[N], r[N], last = -1;
bool has_fa[N], is_CBT = true;

void bfs(int u) {
    int q[N], front = 1, rear = 1;
    q[rear++] = u;

    while (front != rear) {
        int t = q[front++];
        if (l[t] != -1) q[rear++] = l[t];
        if (r[t] != -1) q[rear++] = r[t];
    }

    for (int i = 1; i <= n / 2; ++i) {
        if (2 * i <= n && q[2 * i] != l[q[i]]) is_CBT = false;
        if (2 * i + 1 <= n && q[2 * i + 1] != r[q[i]]) is_CBT = false;
    }

    if (is_CBT) last = q[rear - 1];
}

int main() {
    memset(l, -1, sizeof(l));
    memset(r, -1, sizeof(r));

    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        string lc, rc;
        cin >> lc >> rc;

        if (lc != "-") {
            int x = stoi(lc);
            l[i] = x;
            has_fa[x] = true;
        }
        if (rc != "-") {
            int x = stoi(rc);
            r[i] = x;
            has_fa[x] = true;
        }
    }

    int root = 0;
    while (has_fa[root]) root++;

    bfs(root);

    if (is_CBT) printf("YES %d\n", last);
    else printf("NO %d\n", root);

    return 0;
}
