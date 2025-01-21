#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;

int n;
int primes[N], len;
bool st[N];    // 标记i是否被筛掉

// 线性筛法
void get_primes() {
    for (int i = 2; i <= n; i++) {
        if (!st[i]) primes[len++] = i;
        for (int j = 0; primes[j] <= n / i; j++) {
            st[primes[j] * i] = true;
            if (i % primes[j] == 0) break;
        }
    }
}

int main() {
    scanf("%d", &n);
    get_primes();

    int cnt = 0;
    for (int i = 1; i < n; i++)
        if (primes[i] - primes[i - 1] == 2) cnt++;
    printf("%d", cnt);

    return 0;
}
