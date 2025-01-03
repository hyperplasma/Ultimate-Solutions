#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <vector>

using namespace std;

int Q, k, m;

struct Solution {
    int n, A;

    bool operator<(const Solution &t) const {
        if (n != t.n) return n < t.n;
        else return A < t.A;
    }
};

vector <Solution> res;

int gcd(int a, int b) {
    return b ? gcd(b, a % b) : a;
}

int is_prime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= n / i; ++i)
        if (n % i == 0) return false;
    return true;
}

int main() {
    scanf("%d", &Q);
    for (int num = 1; num <= Q; ++num) {
        scanf("%d%d", &k, &m);
        res.clear();
        printf("Case %d\n", num);

        int start = pow(10, k - 1);
        bool success = false;
        for (int A = start + 9; A < start * 10; A += 10) {
            int sum = 0, tmpA = A;
            while (tmpA) {
                sum += tmpA % 10;
                tmpA /= 10;
            }

            if (sum != m) continue;

            int n = 0, A1 = A + 1;
            while (A1) {
                n += A1 % 10;
                A1 /= 10;
            }

            int d = gcd(m, n);
            if (is_prime(d) && d > 2) {
                res.push_back({n, A});
                success = true;
            }
        }

        if (!success) printf("No Solution\n");
        else {
            sort(res.begin(), res.end());
            for (auto it: res)
                printf("%d %d\n", it.n, it.A);
        }

    }

    return 0;
}
