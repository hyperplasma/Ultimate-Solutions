#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1010;

double a[N], b[N], c[N * 2];

void input(double a[]) {
    int k;
    cin >> k;
    while (k--) {
        int n;
        double v;
        cin >> n >> v;
        a[n] = v;
    }
}

int main() {
    input(a);
    input(b);

    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            c[i + j] += b[i] * a[j];

    int k = 0;
    for (int i = 0; i < N * 2; i++)
        if (c[i]) k++;

    cout << k;
    for (int i = N * 2 - 1; i >= 0; i--)
        if (c[i]) printf(" %d %.1lf", i, c[i]);

    return 0;
}
