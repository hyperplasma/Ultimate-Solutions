#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010, INF = 0x3f3f3f3f;

int n, M;
int s[N];

int main() {
    scanf("%d%d", &n, &M);

    for (int i = 1; i <= n; ++i) {
        scanf("%d", &s[i]);
        s[i] += s[i - 1];
    }

    int res = INF;
    for (int i = 1, j = 0; i <= n; ++i) {
        while (s[i] - s[j + 1] >= M) j++;
        if (s[i] - s[j] >= M) res = min(res, s[i] - s[j]);
    }

    for (int i = 1, j = 0; i <= n; ++i) {
        while (s[i] - s[j + 1] >= M) j++;
        if (s[i] - s[j] == res) printf("%d-%d\n", j + 1, i);
    }
    return 0;
}
