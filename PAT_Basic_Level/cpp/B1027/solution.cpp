#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

int n;
char c;

int main() {
    scanf("%d %c", &n, &c);

    int x = (int) sqrt((n + 1) / 2.0);
    for (int i = 0; i < x; i++) {
        for (int j = 0; j < i; j++) printf(" ");
        for (int j = 0; j < 2 * (x - i) - 1; j++) printf("%c", c);
        printf("\n");
    }
    for (int i = x - 2; i >= 0; i--) {
        for (int j = 0; j < i; j++) printf(" ");
        for (int j = 0; j < 2 * (x - i) - 1; j++) printf("%c", c);
        printf("\n");
    }
    printf("%d\n", n - 2 * x * x + 1);

    return 0;
}
