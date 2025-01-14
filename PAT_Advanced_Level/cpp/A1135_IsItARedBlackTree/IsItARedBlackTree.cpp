#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 5029;        // 未明确给出结点值范围，经测N=5028时测试点3会段错误

int n, Q;
int pre[N], in[N], inpos[N];
bool is_black[N], flag = true;

int build(int inL, int inR, int preL, int preR, int &sum) {    // sum: 黑结点总数
    int root = pre[preL];
    int k = inpos[root];

    if (k < inL || k > inR) {
        flag = false;
        return 0;
    }

    int lchild = 0, rchild = 0, lsum = 0, rsum = 0;
    if (inL < k) lchild = build(inL, k - 1, preL + 1, preL + 1 + (k - 1 - inL), lsum);
    if (k < inR) rchild = build(k + 1, inR, preL + 1 + (k - 1 - inL) + 1, preR, rsum);

    if (lsum != rsum) flag = false;

    sum = lsum;
    if (is_black[root]) sum++;
    else if (!is_black[lchild] || !is_black[rchild]) flag = false;

    return root;
}

int main() {
    scanf("%d", &Q);
    while (Q--) {
        flag = true;
        memset(is_black, true, sizeof is_black);
        memset(inpos, -1, sizeof inpos);

        scanf("%d", &n);
        for (int i = 0; i < n; ++i) {
            int x;
            scanf("%d", &x);
            pre[i] = abs(x);
            in[i] = pre[i];

            if (x >= 0) is_black[pre[i]] = true;
            else is_black[pre[i]] = false;
        }
        sort(in, in + n);

        for (int i = 0; i < n; ++i) inpos[in[i]] = i;

        int sum = 0;
        int root = build(0, n - 1, 0, n - 1, sum);
        if (!is_black[root]) flag = false;

        if (flag) printf("Yes\n");
        else printf("No\n");
    }

    return 0;
}
