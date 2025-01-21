#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

struct Polynominal {
    int coef, expon;
} p;

int main() {
    int cnt = 0;
    while (~scanf("%d %d", &p.coef, &p.expon)) {
        if (p.coef == 0 || p.expon == 0) continue;

        if (cnt == 0) printf("%d %d", p.coef * p.expon, p.expon - 1);
        else printf(" %d %d", p.coef * p.expon, p.expon - 1);
        cnt++;
    }

    if (cnt == 0) printf("0 0");

    return 0;
}
