#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 1010;

double a[N], b[N];
vector <pair<int, double>> c;    // (expon, coef)

void input(double a[]) {
    int n;
    scanf("%d", &n);
    while (n--) {
        int expon;
        double coef;
        scanf("%d%lf", &expon, &coef);
        a[expon] = coef;
    }
}

int main() {
    input(a);
    input(b);

    for (int i = N - 1; i >= 0; i--)
        if (a[i] + b[i])
            c.push_back({i, a[i] + b[i]});

    cout << c.size();
    for (auto it: c)
        printf(" %d %.1f", it.first, it.second);

    return 0;
}
