#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
using namespace std;

int c1, c2;

int main() {
	scanf("%d %d", &c1, &c2);

    int x = floor((c2 - c1) / 100.0 + 0.5);
    printf("%02d:%02d:%02d\n", x / 3600, x % 3600 / 60, x % 60);

	return 0;
}
