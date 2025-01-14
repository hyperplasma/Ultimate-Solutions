#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10;
const int MOD = 1000000007;

char a[N];

int main() {
    LL num = 0, cnt_T = 0, cnt_P = 0, ans = 0;
    while (~scanf("%c", &a[num])) {
        if (a[num] == 'T') cnt_T++;    // 统计T的个数
        num++;
    }

    for (LL j = 0; j < num; j++) {
        if (a[j] == 'A')
            ans = (ans + cnt_P * cnt_T) % MOD;    // 运算后取模
        else if (a[j] == 'P')
            cnt_P++;    // 统计当前位左边的P的个数
        else if (a[j] == 'T')
            cnt_T--;    // 统计当前位右边的T的个数
    }

    cout << ans;

    return 0;
}
