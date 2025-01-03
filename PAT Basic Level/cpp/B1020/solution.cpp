#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1010;

int n;
double d, profit;
struct Cake {
    double unit_p, total_p, stock;
} cakes[N];

int cmp(Cake &a, Cake &b) {
    return a.unit_p > b.unit_p;
}

int main() {
    scanf("%d %lf", &n, &d);
    for (int i = 0; i < n; i++) scanf("%lf", &cakes[i].stock);

    for (int i = 0; i < n; i++) {
        scanf("%lf", &cakes[i].total_p);
        cakes[i].unit_p = cakes[i].total_p / cakes[i].stock;
    }

    sort(cakes, cakes + n, cmp);
    for (int i = 0; i < n; ++i)
        if (d - cakes[i].stock > 0) {
            profit += cakes[i].total_p;
            d -= cakes[i].stock;
        } else {
            profit += d * cakes[i].unit_p;
            break;
        }

    printf("%.2f", profit);

    return 0;
}
