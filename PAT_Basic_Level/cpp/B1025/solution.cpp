#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 100010;

int n, m;
int h, e[N], ne[N];

int main() {
    scanf("%d%d%d", &h, &n, &m);

    for (int i = 0; i < n; i++) {
        int addr, data, next;
        scanf("%d%d%d", &addr, &data, &next);
        e[addr] = data, ne[addr] = next;
    }

    vector<int> q;
    for (int i = h; i != -1; i = ne[i]) q.push_back(i);

    for (int i = 0; i + m - 1 < q.size(); i += m)
        reverse(q.begin() + i, q.begin() + i + m);

    for (int i = 0; i < q.size(); i++) {
        printf("%05d %d ", q[i], e[q[i]]);
        if (i + 1 == q.size()) puts("-1");
        else printf("%05d\n", q[i + 1]);
    }

    return 0;
}
