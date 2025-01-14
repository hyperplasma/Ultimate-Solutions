#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int n, cnt;

int main() {
    cin >> n;
    while (n != 1) {
        if (n % 2 == 0) n /= 2;
        else n = (3 * n + 1) / 2;
        cnt++;
    }
    cout << cnt;

    return 0;
}
