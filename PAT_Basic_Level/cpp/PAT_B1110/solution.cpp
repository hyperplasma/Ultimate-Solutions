#include<iostream>
#include<cstring>
#include<algorithm>
#include<vector>

using namespace std;

const int MAXN = 100010;

int n, k, head;
struct Node {
    int addr, data, next;
} node[MAXN];
vector <Node> L;

int main() {
    scanf("%d%d%d", &head, &n, &k);
    for (int i = 0; i < n; ++i) {
        int addr, data, next;
        scanf("%d%d%d", &addr, &data, &next);
        node[addr] = {addr, data, next};
    }

    for (int p = head; p != -1; p = node[p].next)
        L.push_back(node[p]);

    for (int i = 0; i < (int) L.size(); i += k)
        reverse(L.begin() + i, L.begin() + min((int) L.size(), i + k));
    reverse(L.begin(), L.end());

    for (int i = 0; i < L.size() - 1; ++i)
        printf("%05d %d %05d\n", L[i].addr, L[i].data, L[i + 1].addr);
    printf("%05d %d -1\n", L[L.size() - 1].addr, L[L.size() - 1].data);

    return 0;
}
