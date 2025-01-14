#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 100010;

int n;
int h, e[N], ne[N];
bool st[N];

int main() {
    scanf("%d%d", &h, &n);
    for (int i = 0; i < n; i++) {
        int addr, key, next;
        scanf("%d%d%d", &addr, &key, &next);
        e[addr] = key, ne[addr] = next;
    }

    vector<int> a, b;
    for (int i = h; i != -1; i = ne[i]) {
        int v = abs(e[i]);
        if (st[v]) b.push_back(i);
        else {
            st[v] = true;
            a.push_back(i);
        }
    }

    for (int i = 0; i < a.size(); i++) {
        printf("%05d %d ", a[i], e[a[i]]);
        if (i + 1 == a.size()) puts("-1");
        else printf("%05d\n", a[i + 1]);
    }
    for (int i = 0; i < b.size(); i++) {
        printf("%05d %d ", b[i], e[b[i]]);
        if (i + 1 == b.size()) puts("-1");
        else printf("%05d\n", b[i + 1]);
    }

    return 0;
}
