#include <iostream>
#include <cstring>

using namespace std;

const int MAXN = 10010;

int n, T;
int a[MAXN];
bool has_exceeded = false;

int main() {
    scanf("%d%d", &n, &T);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);

    for (int i = 0; i < n;) {
        if (a[i] > T) {
            has_exceeded = true;
            int j = i + 1;
            while (j < n && a[j] > T) j++;

            printf("[%d, %d]\n", i, j - 1);
            i = j;
        } else i++;
    }

    if (!has_exceeded) {
        int max = -1;
        for (int i = 0; i < n; ++i) {
            if (a[i] > max) max = a[i];
        }
        printf("%d\n", max);
    }

    return 0;
}