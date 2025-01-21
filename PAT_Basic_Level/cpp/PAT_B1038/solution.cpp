#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int MAXN = 100010;

int n, k;
int cnt[MAXN];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        int score;
        scanf("%d", &score);
        cnt[score]++;
    }

    scanf("%d", &k);
    for (int i = 0; i < k; i++) {
        int score;
        scanf("%d", &score);
        if (i) printf(" ");
        printf("%d", cnt[score]);
    }

    return 0;
}
