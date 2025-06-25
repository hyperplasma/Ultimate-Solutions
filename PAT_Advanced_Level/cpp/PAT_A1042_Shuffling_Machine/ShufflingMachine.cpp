#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

const int N = 60;

int k;
int q[N], p[N], w[N];

void print(int x) {
    if (x <= 13) cout << 'S' << x;
    else if (x <= 26) cout << 'H' << x - 13;
    else if (x <= 39) cout << 'C' << x - 26;
    else if (x <= 52) cout << 'D' << x - 39;
    else cout << 'J' << x - 52;
}

int main() {
    cin >> k;
    for (int i = 1; i <= 54; i++) cin >> q[i];
    for (int i = 1; i <= 54; i++) p[i] = i;

    while (k--) {
        memcpy(w, p, sizeof w);
        for (int i = 1; i <= 54; i++) p[q[i]] = w[i];
    }

    for (int i = 1; i <= 54; i++) {
        print(p[i]);
        if (i != 54) cout << ' ';
    }

    return 0;
}