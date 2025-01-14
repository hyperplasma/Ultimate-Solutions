#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1010;

double n, m;

struct Cake {
    double p, w;

    bool operator<(const Cake &t) const {
        return p / w > t.p / t.w;
    }
} c[N];

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; ++i) cin >> c[i].w;
    for (int i = 0; i < n; ++i) cin >> c[i].p;

    sort(c, c + (int) n);

    double res = 0;
    for (int i = 0; i < n && m > 0; ++i) {
        double r = min(m, c[i].w);
        m -= r;
        res += c[i].p / c[i].w * r;
    }

    printf("%.2lf\n", res);

    return 0;
}
