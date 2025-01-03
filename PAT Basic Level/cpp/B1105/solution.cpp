#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 100010;

int n;
int h1, h2, e[N], ne[N];
vector<int> L1, L2, L;

int main() {
    scanf("%d%d%d", &h1, &h2, &n);
    for (int i = 0; i < n; ++i) {
        int addr, data, next;
        scanf("%d%d%d", &addr, &data, &next);
        e[addr] = data;
        ne[addr] = next;
    }

    for (int p = h1; p != -1; p = ne[p]) L1.push_back(p);
    for (int p = h2; p != -1; p = ne[p]) L2.push_back(p);

    if (L2.size() > L1.size()) swap(L1, L2);    // 保证L1长于L2
    reverse(L2.begin(), L2.end());

    for (int i = 0, j = 0; i < L1.size(); ++i) {
        L.push_back(L1[i]);
        if ((i + 1) % 2 == 0 && j < L2.size()) {
            L.push_back(L2[j]);
            j++;
        }
    }

    for (int i = 0; i < L.size(); ++i) {
        if (i < L.size() - 1) printf("%05d %d %05d\n", L[i], e[L[i]], L[i + 1]);
        else printf("%05d %d -1\n", L[i], e[L[i]]);
    }

    return 0;
}
