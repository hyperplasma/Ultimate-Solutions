#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>
#include <stack>

using namespace std;

const int N = 40;

int n;
unordered_map<int, int> l, r;
int in[N], post[N];

int build(int inL, int inR, int postL, int postR) {
    if (inL > inR) return 0;

    int root = post[postR];
    int k;
    for (k = inL; k <= inR; ++k)
        if (in[k] == root) break;

    if (inL < k) l[root] = build(inL, k - 1, postL, postL + (k - 1 - inL));
    if (k < inR) r[root] = build(k + 1, inR, postL + (k - 1 - inL) + 1, postR - 1);

    return root;
}

void bfs(int u) {
    stack<int> stk;
    stk.push(u);

    int cnt = 1;
    bool is_first = true;
    while (!stk.empty()) {
        stack<int> new_stk;
        while (!stk.empty()) {
            int t = stk.top();
            stk.pop();

            if (is_first) is_first = false;
            else printf(" ");
            printf("%d", t);

            if (cnt % 2 == 1) {
                if (r[t]) new_stk.push(r[t]);
                if (l[t]) new_stk.push(l[t]);
            } else {
                if (l[t]) new_stk.push(l[t]);
                if (r[t]) new_stk.push(r[t]);
            }
        }

        stk = new_stk;
        cnt++;
    }
    printf("\n");
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &in[i]);
    for (int i = 0; i < n; ++i) scanf("%d", &post[i]);

    int root = build(0, n - 1, 0, n - 1);
    bfs(root);

    return 0;
}
