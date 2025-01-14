#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010;

int n;
int pos[N];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        int x;
        scanf("%d", &x);
        pos[x] = i;
    }

    int cnt = 0;
    for (int i = 1; i < n;) {
        while (pos[0] != 0) {
            swap(pos[0], pos[pos[0]]);
            cnt++;
        }

        while (i < n && pos[i] == i) i++;
        if (i < n) {
            swap(pos[0], pos[i]);
            cnt++;
        }
    }
    printf("%d\n", cnt);

    return 0;
}
