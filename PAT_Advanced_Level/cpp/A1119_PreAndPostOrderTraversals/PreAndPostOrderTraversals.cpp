#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 40;

int n;
int pre[N], post[N];
vector<int> in;
bool is_unique = true;

void dfs(int preL, int preR, int postL, int postR) {
    if (preL == preR) {
        in.push_back(pre[preL]);
        return;
    }

    if (pre[preL] == post[postR]) {
        int k;
        for (k = preL + 1; k <= preR; ++k)
            if (pre[k] == post[postR - 1])
                break;

        if (k > preL + 1)    // k号未紧挨着根(preL)，则k号必为右子树根，此时必存在左子树
            dfs(preL + 1, k - 1, postL, postL + (k - 1 - preL - 1)); // 区间长度一致
        else is_unique = false;

        in.push_back(pre[preL]);    // 中序：“左根右”
        dfs(k, preR, postL + (k - 1 - preL - 1) + 1, postR - 1); // 无论是否唯一，默认k号为右子树根
    }
}


int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &pre[i]);
    for (int i = 0; i < n; ++i) scanf("%d", &post[i]);

    dfs(0, n - 1, 0, n - 1);

    if (is_unique) printf("Yes\n");
    else printf("No\n");

    for (int i = 0; i < n; ++i) {
        if (i > 0) printf(" ");
        printf("%d", in[i]);
    }
    printf("\n");

    return 0;
}
