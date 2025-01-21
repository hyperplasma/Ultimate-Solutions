#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>
#include <queue>

using namespace std;

const int N = 40;

int n;
int postorder[N], inorder[N];
unordered_map<int, int> l, r, inpos;

int build(int postL, int postR, int inL, int inR) {
    int root = postorder[postR];
    int k = inpos[root];
    if (k > inL)
        l[root] = build(postL, postL + (k - 1 - inL), inL, k - 1);
    if (k < inR)
        r[root] = build(postL + k - inL, postR - 1, k + 1, inR);
    return root;
}

void bfs(int root) {
    int Q[N];
    int front = -1, rear = -1;
    Q[++rear] = root;

    while (front != rear) {
        int p = Q[++front];
        if (l.count(p)) Q[++rear] = l[p];
        if (r.count(p)) Q[++rear] = r[p];
    }

    for (int i = 0; i < n; ++i) {
        cout << Q[i];
        printf((i == n - 1) ? "\n" : " ");
    }
}

int main() {
    cin >> n;

    for (int i = 0; i < n; ++i) cin >> postorder[i];
    for (int i = 0; i < n; ++i) {
        cin >> inorder[i];
        inpos[inorder[i]] = i;
    }

    int root = build(0, n - 1, 0, n - 1);
    bfs(root);

    return 0;
}
