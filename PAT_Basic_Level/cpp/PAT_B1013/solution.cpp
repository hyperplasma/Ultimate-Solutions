#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int m, n;

bool is_prime(int num) {
    for (int i = 2; i * i <= num; ++i)
        if (num % i == 0)
            return false;
    return true;
}

int main() {
    scanf("%d%d", &m, &n);

    int idx = 0, cnt = 0;
    long long num = 2;
    while (idx < n) {
        if (is_prime(num)) {
            idx++;
            if (idx >= m) {
                printf("%lld", num);
                cnt++;
                if (idx < n && cnt < 10) printf(" ");
                if (cnt == 10) {
                    cnt = 0;
                    printf("\n");
                }
            }
        }
        num += 1;
    }

    return 0;
}
