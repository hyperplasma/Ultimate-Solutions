#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 100010;

int n, k;
int head, e[N], ne[N];
vector<int> L;

int main() {
    scanf("%d%d%d", &head, &n, &k);

    for (int i = 0; i < n; ++i) {
        int addr, data, next;
        scanf("%d%d%d", &addr, &data, &next);
        e[addr] = data;
        ne[addr] = next;
    }

    for (int p = head; p != -1; p = ne[p]) L.push_back(p);

    for (int i = 0; i < L.size(); i += k)
        reverse(L.begin() + i, L.begin() + min(i + k, (int) L.size()));

    reverse(L.begin(), L.end());

    for (int i = 0; i < L.size() - 1; ++i)
        printf("%05d %d %05d\n", L[i], e[L[i]], L[i + 1]);
    printf("%05d %d -1\n", L[L.size() - 1], e[L[L.size() - 1]]);

    return 0;
}
