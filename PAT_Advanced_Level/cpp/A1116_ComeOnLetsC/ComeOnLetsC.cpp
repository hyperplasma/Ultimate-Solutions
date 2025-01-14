#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 10010;

int n;
int award[N];
bool is_checked[N];

bool is_prime(int n) {
    if (n <= 1) return false;

    for (int i = 2; i <= n / i; ++i)
        if (n % i == 0) return false;

    return true;
}

int main() {
    scanf("%d", &n);

    for (int i = 0, cnt = 1; i < n; ++i, ++cnt) {
        int x;
        scanf("%d", &x);

        if (cnt == 1) award[x] = 3;                // mystery
        else if (is_prime(cnt)) award[x] = 2;    // minions
        else award[x] = 1;                        // choco
    }

    int Q;
    scanf("%d", &Q);
    while (Q--) {
        int x;
        scanf("%d", &x);

        printf("%04d: ", x);
        if (is_checked[x]) printf("Checked\n");
        else if (!award[x]) printf("Are you kidding?\n");
        else {
            if (award[x] == 3) printf("Mystery Award\n");
            else if (award[x] == 2) printf("Minion\n");
            else printf("Chocolate\n");

            is_checked[x] = true;
        }
    }
    return 0;
}
