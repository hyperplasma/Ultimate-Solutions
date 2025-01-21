#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>

using namespace std;

const int N = 50, INF = 0x3f3f3f3f;

int n;
unordered_map<int, int> l, r, pos;
unordered_map<int, bool> has_l, has_r;
int in[N];

int find_min(int left, int right) {
    int Min = INF;
    for (int i = left; i <= right; ++i)
        Min = min(Min, in[i]);

    return Min;
}

void build(int root, int inL, int inR) {
    if (inL > inR) return;

    int k = pos[root];
    if (find_min(inL, k - 1) != INF) {
        l[root] = find_min(inL, k - 1);
        has_l[root] = true;
    }
    if (find_min(k + 1, inR) != INF) {
        r[root] = find_min(k + 1, inR);
        has_r[root] = true;
    }

    if (has_l[root]) build(l[root], inL, k - 1);
    if (has_r[root]) build(r[root], k + 1, inR);
}

void bfs(int root) {
    int q[N], front = 0, rear = 0;
    q[rear++] = root;

    while (front != rear) {
        int t = q[front++];
        if (has_l[t]) q[rear++] = l[t];
        if (has_r[t]) q[rear++] = r[t];
    }

    for (int i = 0; i < rear; ++i) {
        if (i > 0) printf(" ");
        printf("%d", q[i]);
    }
    printf("\n");
}

int main() {
    scanf("%d", &n);

    int root = INF;
    for (int i = 0; i < n; ++i) {
        scanf("%d", &in[i]);
        pos[in[i]] = i;
        root = min(root, in[i]);
    }

    build(root, 0, n - 1);
    bfs(root);

    return 0;
}
