#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 510;

int c_max, d, d_avg, n;

struct Station {
    double p, d;

    bool operator<(const Station &t) const {
        return d < t.d;
    }
} s[N];

int main() {
    cin >> c_max >> d >> d_avg >> n;
    for (int i = 0; i < n; ++i) cin >> s[i].p >> s[i].d;
    s[n] = {0, (double) d};

    sort(s, s + n + 1);

    if (s[0].d) {
        printf("The maximum travel distance = 0.00\n");
        return 0;
    }

    double res = 0, oil = 0;
    for (int i = 0; i < n;) {
        int k = -1;
        for (int j = i + 1; j <= n && s[j].d - s[i].d <= c_max * d_avg; ++j)
            if (s[j].p < s[i].p) {
                k = j;
                break;
            } else if (k == -1 || s[j].p < s[k].p) k = j;

        if (k == -1) {
            printf("The maximum travel distance = %.2lf\n", s[i].d + (double) c_max * d_avg);
            return 0;
        }

        if (s[k].p <= s[i].p) {
            res += ((s[k].d - s[i].d) / d_avg - oil) * s[i].p;
            oil = 0;
            i = k;
        } else {
            res += (c_max - oil) * s[i].p;
            oil = c_max - (s[k].d - s[i].d) / d_avg;
            i = k;
        }
    }

    printf("%.2lf\n", res);

    return 0;
}
