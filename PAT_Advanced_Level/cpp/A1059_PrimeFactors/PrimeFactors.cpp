#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;

    printf("%d=", n);
    if (n == 1) puts("1");
    else {
        bool is_first = true;
        for (int i = 2; i <= n / i; i++)
            if (n % i == 0) {
                int k = 0;
                while (n % i == 0) {
                    n /= i;
                    k++;
                }
                if (!is_first) cout << '*';
                else is_first = false;

                cout << i;
                if (k > 1) cout << "^" << k;
            }

        if (n > 1) {
            if (!is_first) cout << '*';
            cout << n;
        }
    }

    return 0;
}
