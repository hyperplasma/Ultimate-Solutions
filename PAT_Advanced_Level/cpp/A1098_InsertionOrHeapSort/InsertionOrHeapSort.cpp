#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 110;

int n;
int a[N], b[N];

void down(int u, int size) {
    int t = u;
    if (u * 2 <= size && b[t] < b[u * 2]) t = u * 2;
    if (u * 2 + 1 <= size && b[t] < b[u * 2 + 1]) t = u * 2 + 1;
    if (t != u) {
        swap(b[t], b[u]);
        down(t, size);
    }
}

int main() {
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> a[i];
    for (int i = 1; i <= n; i++) cin >> b[i];

    int p = 2;
    while (p <= n && b[p] >= b[p - 1]) p++;
    int k = p;
    while (p <= n && a[p] == b[p]) p++;
    if (p == n + 1) {
        puts("Insertion Sort");
        while (k > 1 && b[k] < b[k - 1]) {
            swap(b[k], b[k - 1]);
            k--;
        }
    } else {
        puts("Heap Sort");
        p = n;
        while (b[1] <= b[p]) p--;
        swap(b[1], b[p]);
        down(1, p - 1);
    }

    cout << b[1];
    for (int i = 2; i <= n; i++) cout << ' ' << b[i];
    cout << endl;

    return 0;
}
