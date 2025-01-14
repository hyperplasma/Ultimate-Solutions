#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1010;

int n;
int a[N];

int f(int n) {
    if (n == 1) return 2 % 10;
    else if (n == 2) return 0 % 10;
    else if (n == 3) return 1 % 10;
    else if (n == 4) return 9 % 10;
    else return (a[n - 1] + a[n - 2] + a[n - 3] + a[n - 4]) % 10;
}

void init() {
    for (int i = 1; i <= 1000; i++) a[i] = f(i);
}

int main() {
    scanf("%d", &n);
    init();
    for (int i = 1; i <= n; i++) printf("%d", f(i));
    return 0;
}
