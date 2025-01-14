#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010;

int n, h1, h2;
int e[N], ne[N];
bool st[N];

int main() {
    cin >> h1 >> h2 >> n;

    for (int i = 0; i < n; ++i) {
        int addr, next;
        char data;
        cin >> addr >> data >> next;
        e[addr] = data;
        ne[addr] = next;
    }

    for (int p = h1; p != -1; p = ne[p]) st[p] = true;

    int p;
    for (p = h2; p != -1; p = ne[p])
        if (Hash[p]) {
            printf("%05d\n", p);
            break;
        }

    if (p == -1) cout << "-1" << endl;

    return 0;
}
