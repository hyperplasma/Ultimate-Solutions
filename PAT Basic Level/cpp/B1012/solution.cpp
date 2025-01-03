#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1010;

int n;
int a1, a2, a3, a5;
double a4;

int main() {
    scanf("%d", &n);

    int sign = 1, cnt_a2 = 0, cnt_a4 = 0;
    while (n--) {
        int x;
        scanf("%d", &x);
        int r = x % 5;
        switch (r) {
            case 0:
                if (x % 2 == 0) a1 += x;
                break;
            case 1:
                a2 += sign * x;
                sign *= -1;
                cnt_a2++;
                break;
            case 2:
                a3++;
                break;
            case 3:
                a4 += x;
                cnt_a4++;
                break;
            case 4:
                a5 = max(a5, x);
                break;
        }
    }

    if (!a1) printf("N ");
    else printf("%d ", a1);

    if (!cnt_a2) printf("N ");
    else printf("%d ", a2);

    if (!a3) printf("N ");
    else printf("%d ", a3);

    if (!a4) printf("N ");
    else {
        if (cnt_a4) a4 /= cnt_a4;
        printf("%.1f ", a4);
    }

    if (!a5) printf("N");
    else printf("%d", a5);

    return 0;
}
