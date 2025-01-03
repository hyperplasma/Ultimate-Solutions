#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int a, b, c, d, e, f;

int main() {
    scanf("%d.%d.%d %d.%d.%d", &a, &b, &c, &d, &e, &f);
    a += d;
    b += e;
    c += f;

    b += c / 29;
    c %= 29;

    a += b / 17;
    b %= 17;

    printf("%d.%d.%d\n", a, b, c);

    return 0;
}
