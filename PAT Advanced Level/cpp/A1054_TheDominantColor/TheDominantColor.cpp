#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>

using namespace std;

const int N = 810;

int m, n;
unordered_map<int, int> colors;

int main() {
    scanf("%d%d", &m, &n);

    for (int i = 0; i < n; ++i)
        for (int j = 0; j < m; ++j) {
            int x;
            scanf("%d", &x);
            colors[x]++;
        }

    for (auto it: colors)
        if (it.second > m * n / 2) {
            printf("%d\n", it.first);
            break;
        }

    return 0;
};
