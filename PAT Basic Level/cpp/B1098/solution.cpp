#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int n;

int main() {
    scanf("%d", &n);

    int up_min = 1010, down_max = -1;
    for (int i = 0; i < n; i++) {
        int x;
        scanf("%d", &x);
        if (x < up_min) up_min = x;
    }
    for (int i = 0; i < n; i++) {
        int x;
        scanf("%d", &x);
        if (x > down_max) down_max = x;
    }

    if (up_min - down_max >= 1) printf("Yes %d", up_min - down_max);
    else printf("No %d", down_max - up_min + 1);

    return 0;
}
