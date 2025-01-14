#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010;

int n;
int bets[N], cnt[N];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        int x;
        scanf("%d", &x);
        bets[i] = x;
        cnt[x]++;
    }

    bool flag = false;
    for (int i = 0; i < n; ++i)
        if (cnt[bets[i]] == 1) {
            printf("%d\n", bets[i]);
            flag = true;
            break;
        }

    if (!flag) printf("None\n");

    return 0;
}
