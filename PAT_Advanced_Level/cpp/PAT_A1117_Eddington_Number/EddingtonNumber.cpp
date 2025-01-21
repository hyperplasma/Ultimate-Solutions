#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010;

int n;
int a[N];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) scanf("%d", &a[i]);
    sort(a, a + n);

    for (int i = n; i > 0; i--) {
        if (a[n - i] > i) {
            printf("%d\n", i);
            return 0;
        }
    }

    printf("0\n");
    return 0;
}
