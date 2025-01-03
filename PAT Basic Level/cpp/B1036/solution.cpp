#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

int n;
char c;

int main() {
    scanf("%d %c", &n, &c);

    int r = round(1.0 * n / 2);
    for (int i = 0; i < r; i++) {
        if (i == 0 || i == r - 1) {
            for (int j = 0; j < n; j++) printf("%c", c);
            printf("\n");
        } else {
            printf("%c", c);
            for (int j = 1; j < n - 1; j++) printf(" ");
            printf("%c\n", c);
        }
    }

    return 0;
}
